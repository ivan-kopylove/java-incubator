package heap.a50a;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Foo
{
    int id;
    String color;

    public Foo(int id, String color)
    {
        this.id = id;
        this.color = color;
    }
}

class Bar implements Comparable<Bar>{
    int id;
    String color;

    public Bar(int id, String color)
    {
        this.id = id;
        this.color = color;
    }

    @Override
    public int compareTo(Bar o)
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
        PriorityQueue<Foo> priorityQueue = new PriorityQueue<>();



        assertThrows(ClassCastException.class, () -> {
            priorityQueue.add(new Foo(5, "yellow"));
        });
    }



    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        PriorityQueue<Foo> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.id, o2.id));

        priorityQueue.add(new Foo(5, "yellow"));
        priorityQueue.add(new Foo(3, "red"));
        priorityQueue.add(new Foo(4, "green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }



    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        PriorityQueue<Bar> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Bar(5, "yellow"));
        priorityQueue.add(new Bar(3, "red"));
        priorityQueue.add(new Bar(4, "green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }


    @Test
    void exercise_design_reverse_engineering3()
    {
        // given

        PriorityQueue<Bar> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.id, o1.id));


        priorityQueue.add(new Bar(5, "yellow"));
        priorityQueue.add(new Bar(3, "red"));
        priorityQueue.add(new Bar(4, "green"));


        assertEquals(priorityQueue.poll().color, "yellow");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "red");

    }
}
