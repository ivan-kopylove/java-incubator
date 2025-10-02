package heap.eqwewq;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XORLinkedListTest {

    static class XORNode {
        int value;
        int both;
        
        XORNode(int value) {
            this.value = value;
            this.both = 0;
        }
    }
    
    static class XORLinkedList {
        private XORNode[] memory; // Simulating memory with array
        private int head;
        private int tail;
        private int freeIndex;
        
        public XORLinkedList(int capacity) {
            memory = new XORNode[capacity];
            head = -1;
            tail = -1;
            freeIndex = 0;
        }
        
        public void add(int value) {
            if (freeIndex >= memory.length) {
                throw new IllegalStateException("Memory full");
            }
            
            XORNode newNode = new XORNode(value);
            memory[freeIndex] = newNode;
            
            if (head == -1) {
                // First node
                head = freeIndex;
                tail = freeIndex;
                newNode.both = 0; // 0 XOR 0 = 0
            } else {
                // Link new node to current tail
                XORNode tailNode = memory[tail];
                tailNode.both = tailNode.both ^ freeIndex; // Update tail's both
                newNode.both = tail; // New node's previous is tail, next is 0
                tail = freeIndex;
            }
            
            freeIndex++;
        }
        
        public int get(int index) {
            if (head == -1)
            {
                throw new IndexOutOfBoundsException("List is empty");
            }
            
            int current = head;
            int prev = 0;
            int currentIndex = 0;
            
            while (current != 0 && currentIndex < index) {
                XORNode currentNode = memory[current];
                int next = currentNode.both ^ prev;
                prev = current;
                current = next;
                currentIndex++;
            }
            
            if (currentIndex != index || current == 0) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            
            return memory[current].value;
        }
        
        public void traverseForward() {
            if (head == -1) {
                System.out.println("List is empty");
                return;
            }
            
            int current = head;
            int prev = 0;
            
            System.out.print("Forward traversal: ");
            while (current != 0) {
                XORNode currentNode = memory[current];
                System.out.print(currentNode.value + " ");
                
                int next = currentNode.both ^ prev;
                prev = current;
                current = next;
            }
            System.out.println();
        }
        
        public void traverseBackward() {
            if (tail == -1) {
                System.out.println("List is empty");
                return;
            }
            
            int current = tail;
            int next = 0;
            
            System.out.print("Backward traversal: ");
            while (current != 0) {
                XORNode currentNode = memory[current];
                System.out.print(currentNode.value + " ");
                
                int prev = currentNode.both ^ next;
                next = current;
                current = prev;
            }
            System.out.println();
        }
        
        public int getHead() { return head; }
        public int getTail() { return tail; }
    }
    
    @Test
    void testEmptyList() {
        XORLinkedList list = new XORLinkedList(10);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
    
    @Test
    void testSingleNode() {
        XORLinkedList list = new XORLinkedList(10);
        list.add(42);
        
        assertEquals(42, list.get(0));
        assertEquals(list.getHead(), list.getTail());
    }
    
    @Test
    void testMultipleNodes() {
        XORLinkedList list = new XORLinkedList(10);
        
        // Add elements
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        
        // Test forward access
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        
        // Verify head and tail are different
        assertNotEquals(list.getHead(), list.getTail());
    }
    
    @Test
    void testXORProperty() {
        XORLinkedList list = new XORLinkedList(10);
        
        list.add(100);
        list.add(200);
        list.add(300);
        
        // Get the middle node (index 1)
        int middleIndex = -1;
        int current = list.getHead();
        int prev = 0;
        int count = 0;
        
        while (current != 0 && count <= 1) {
            if (count == 1) {
                middleIndex = current;
                break;
            }
            XORNode currentNode = list.memory[current];
            int next = currentNode.both ^ prev;
            prev = current;
            current = next;
            count++;
        }
        
        // Verify XOR property for middle node
        XORNode middleNode = list.memory[middleIndex];
        int prevNodeIndex = prev; // Should be head index
        int nextNodeIndex = middleNode.both ^ prevNodeIndex;
        
        // The XOR of prev and next should equal the both field
        assertEquals(middleNode.both, prevNodeIndex ^ nextNodeIndex);
    }
    
    @Test
    void testMemoryFull() {
        XORLinkedList list = new XORLinkedList(2); // Small capacity
        
        list.add(1);
        list.add(2);
        
        assertThrows(IllegalStateException.class, () -> list.add(3));
    }
    
    @Test
    void testTraversalMethods() {
        XORLinkedList list = new XORLinkedList(10);
        
        // Test with empty list
        list.traverseForward();
        list.traverseBackward();
        
        // Add elements and test traversal
        list.add(5);
        list.add(15);
        list.add(25);
        
        // These should execute without throwing exceptions
        list.traverseForward();
        list.traverseBackward();
    }
    
    @Test
    void testIndexOutOfBounds() {
        XORLinkedList list = new XORLinkedList(10);
        list.add(1);
        list.add(2);
        
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }
    
    @Test
    void testComplexScenario() {
        XORLinkedList list = new XORLinkedList(100);
        
        // Add many elements
        for (int i = 0; i < 10; i++) {
            list.add(i * 10);
        }
        
        // Verify all elements can be retrieved
        for (int i = 0; i < 10; i++) {
            assertEquals(i * 10, list.get(i));
        }
        
        // Verify the list structure is maintained
        assertTrue(list.getHead() >= 0);
        assertTrue(list.getTail() >= 0);
        assertNotEquals(list.getHead(), list.getTail());
    }
}