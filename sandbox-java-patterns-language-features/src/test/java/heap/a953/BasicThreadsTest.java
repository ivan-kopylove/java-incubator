package heap.a953;

import org.junit.jupiter.api.Test;

/**
 * java.mechanics.concurrency.threadYield
 * <p>
 * Examples from Eckel's book.
 */
class BasicThreadsTest
{
    @Test
    void run_test()
    {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
