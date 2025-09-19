package heap.aedc;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListExampleTest
{
    @Test
    void what_does_this_example_demonstrate()
    {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.addFirst("a");

        assertEquals("a", linkedList.get(0));
        assertEquals("b", linkedList.get(1));
        assertEquals("c", linkedList.get(2));
        assertEquals("d", linkedList.get(3));
    }

    @Test
    void run2()
    {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add(0, "a");
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");

        boolean bRemoved = linkedList.removeLastOccurrence("b");
        assertTrue(bRemoved);

        assertEquals("a", linkedList.get(0));
        assertEquals("a", linkedList.get(1));
        assertEquals("b", linkedList.get(2));
        assertEquals("c", linkedList.get(3));
    }

    @Test
    void run3()
    {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");

        String peeked = linkedList.peek();
        assertEquals(peeked, "a");
        assertEquals(4, linkedList.size());


        String poped = linkedList.pop();

        assertEquals(poped, "a");
        assertEquals(3, linkedList.size());
    }

    @Test
    void run4()
    {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.poll();

        assertEquals(2, linkedList.size());
        assertEquals("b", linkedList.get(0));
        assertEquals("c", linkedList.get(1));
    }
}
