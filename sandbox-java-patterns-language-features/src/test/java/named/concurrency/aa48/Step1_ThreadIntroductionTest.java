package named.concurrency.aa48;

import org.junit.jupiter.api.Test;

public class Step1_ThreadIntroductionTest
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