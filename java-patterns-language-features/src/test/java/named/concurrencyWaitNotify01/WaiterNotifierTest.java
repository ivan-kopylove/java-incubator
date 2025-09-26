package named.concurrencyWaitNotify01;

import org.junit.jupiter.api.Test;

class WaiterNotifierTest
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example() throws InterruptedException
    {
        Message msg = new Message("process it");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "waiter2").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        Thread.sleep(5000);
        System.out.println("All the threads are started");
    }
}
