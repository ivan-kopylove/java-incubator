package heap.b860;

import org.junit.jupiter.api.Test;


class BasicNotificationTest
{
    static Object lock = new Object();

    @Test
    void should_resume_execution_once_notify_called() throws InterruptedException
    {
        new Thread(() -> {
            synchronized (lock)
            {
                try
                {
                    System.out.println("Thread VolatileTest: Waiting");
                    lock.wait();
                    System.out.println("Thread VolatileTest: Resumed");
                }
                catch (InterruptedException e)
                {
                }
            }
        }).start();

        Thread.sleep(3_000); // Ensure ordering

        synchronized (lock) // try to drop it and explain
        {
            System.out.println("Thread B: Notifying");
            lock.notify();
        }
    }
}