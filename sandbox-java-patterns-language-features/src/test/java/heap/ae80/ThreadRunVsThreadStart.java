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

        thread.start(); // executes all the required mechanisms to run a new thread.
    }

    @Test
    void foo()
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

        thread.run(); // just runs the overridden method.
    }
}
