package heap.a50a;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyNonComparable
{
    int    id;
    String color;

    MyNonComparable(int id, String color)
    {
        this.id = id;
        this.color = color;
    }
}

class MyComparable implements Comparable<MyComparable>
{
    int    id;
    String color;

    MyComparable(int id, String color)
    {
        this.id = id;
        this.color = color;
    }

    @Override
    public int compareTo(MyComparable o)
    {
        return Integer.compare(this.id, o.id);
    }
}

class PriorityQueObjectExampleTest extends TestBase
{
    @Test
    void why_this_throws()
    {
        // given
        PriorityQueue<MyNonComparable> priorityQueue = new PriorityQueue<>();


        assertThrows(ClassCastException.class, () -> {
            priorityQueue.add(new MyNonComparable(5, "yellow"));
        });
    }

    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        PriorityQueue<MyNonComparable> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.id, o2.id));

        priorityQueue.add(new MyNonComparable(5, "yellow"));
        priorityQueue.add(new MyNonComparable(3, "red"));
        priorityQueue.add(new MyNonComparable(4, "green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        PriorityQueue<MyComparable> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new MyComparable(5, "yellow"));
        priorityQueue.add(new MyComparable(3, "red"));
        priorityQueue.add(new MyComparable(4, "green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }

    @Test
    void exercise_design_reverse_engineering3()
    {
        // given

        PriorityQueue<MyComparable> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.id, o1.id));


        priorityQueue.add(new MyComparable(5, "yellow"));
        priorityQueue.add(new MyComparable(3, "red"));
        priorityQueue.add(new MyComparable(4, "green"));


        assertEquals(priorityQueue.poll().color, "yellow");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "red");
    }
}
