package heap.a98b;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ColoredNumber{
    int id;
    String color;

    public ColoredNumber(int id, String color)
    {
        this.id = id;
        this.color = color;
    }
}

class ColoredNumber2 implements Comparable<ColoredNumber2>{
    int id;
    String color;

    public ColoredNumber2(int id, String color)
    {
        this.id = id;
        this.color = color;
    }

    @Override
    public int compareTo(ColoredNumber2 o)
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
        PriorityQueue<ColoredNumber> priorityQueue = new PriorityQueue<>();


        assertThrows(ClassCastException.class, () -> {
            priorityQueue.add(new ColoredNumber(5,"yellow"));
        });
    }



    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        PriorityQueue<ColoredNumber> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.id, o2.id));

        priorityQueue.add(new ColoredNumber(5,"yellow"));
        priorityQueue.add(new ColoredNumber(3,"red"));
        priorityQueue.add(new ColoredNumber(4,"green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }



    @Test
    void exercise_design_reverse_engineering2()
    {
        // given

        PriorityQueue<ColoredNumber2> priorityQueue = new PriorityQueue<>();


        priorityQueue.add(new ColoredNumber2(5,"yellow"));
        priorityQueue.add(new ColoredNumber2(3,"red"));
        priorityQueue.add(new ColoredNumber2(4,"green"));

        assertEquals(priorityQueue.poll().color, "red");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "yellow");
    }


    @Test
    void exercise_design_reverse_engineering3()
    {
        // given

        PriorityQueue<ColoredNumber2> priorityQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.id, o1.id));


        priorityQueue.add(new ColoredNumber2(5,"yellow"));
        priorityQueue.add(new ColoredNumber2(3,"red"));
        priorityQueue.add(new ColoredNumber2(4,"green"));


        assertEquals(priorityQueue.poll().color, "yellow");
        assertEquals(priorityQueue.poll().color, "green");
        assertEquals(priorityQueue.poll().color, "red");


    }




}
