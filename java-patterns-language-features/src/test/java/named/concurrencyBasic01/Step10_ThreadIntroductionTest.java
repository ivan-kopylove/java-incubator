package named.concurrencyBasic01;

import org.junit.jupiter.api.Test;

import heap.qweqweweqweq.TestBase;
class Step10_ThreadIntroductionTest extends TestBase
{

    @Test
    void twoThreadsPrinting() throws InterruptedException
    {
        Thread thread1 = new Thread(() -> {
            System.out.println("Hello");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("World");
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}