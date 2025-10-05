package heap.a50a;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PriorityQueExampleTest extends TestBase
{
    @Test
    void test2()
    {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("b");
        priorityQueue.add("a");
        priorityQueue.add("c");

        assertEquals(priorityQueue.poll(), "a");
        assertEquals(priorityQueue.poll(), "b");
        assertEquals(priorityQueue.poll(), "c");
    }

    @Test
    void test3()
    {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("1");
        priorityQueue.add("3");
        priorityQueue.add("2");

        assertEquals(priorityQueue.poll(), "1");
        assertEquals(priorityQueue.poll(), "2");
        assertEquals(priorityQueue.poll(), "3");
    }

    @Test
    void exercise_design_reverse_engineering()
    {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.add("a");
        priorityQueue.add("b");
        priorityQueue.add("c");
        priorityQueue.add("1");
        priorityQueue.add("2");
        priorityQueue.add("3");
        priorityQueue.add("a1");
        priorityQueue.add("a11");
        priorityQueue.add("1a");
        priorityQueue.add("1aa");

        assertEquals(priorityQueue.poll(), "1");
        assertEquals(priorityQueue.poll(), "1a");
        assertEquals(priorityQueue.poll(), "1aa");
        assertEquals(priorityQueue.poll(), "2");
        assertEquals(priorityQueue.poll(), "3");
        assertEquals(priorityQueue.poll(), "a");
        assertEquals(priorityQueue.poll(), "a1");
        assertEquals(priorityQueue.poll(), "a11");
        assertEquals(priorityQueue.poll(), "b");
        assertEquals(priorityQueue.poll(), "c");
    }
}
