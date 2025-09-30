package heap.b33b;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Volatile21Test extends TestBase
{
    private volatile int counter1 = 0;

    @Test
    void exercise_design_reverse_engineering() throws InterruptedException
    {
        int tasksCount = 1_000_000;
        CountDownLatch latch = new CountDownLatch(tasksCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < tasksCount; i++)
        {
            executor.submit(() -> {
                counter1++;

                latch.countDown();
            });
        }

        latch.await();

        System.out.println(counter1);
    }
}
