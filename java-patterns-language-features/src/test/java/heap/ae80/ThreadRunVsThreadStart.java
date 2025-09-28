package heap.ae80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ThreadRunVsThreadStart
{
    @Test
    void exercise_design_reverse_engineering1()
    {
        String parentThreadName = Thread.currentThread().getName();
        Thread thread = new Thread()
        {
            public void foo()
            {
                String childThreadName = Thread.currentThread().getName();
                assertNotEquals(parentThreadName, childThreadName);
            }
        };

        thread.start(); // how just the fact of running a method runs a separate thread?
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        String parentThreadName = Thread.currentThread().getName();
        Thread thread = new Thread()
        {
            public void foo()
            {
                String childThreadName = Thread.currentThread().getName();
                assertEquals(parentThreadName, childThreadName);
            }
        };

        thread.run(); // what does this run compared to what?
    }
}
