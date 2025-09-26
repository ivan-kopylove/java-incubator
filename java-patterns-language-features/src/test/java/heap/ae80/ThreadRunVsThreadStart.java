package heap.ae80;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ThreadRunVsThreadStart
{
    @Test
    void start()
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
    void reverse_engineer_hypothetical_design()
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
