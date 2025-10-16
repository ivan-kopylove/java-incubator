package heap.b33b;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

class Volatile10Test extends TestBase
{
    private volatile int counter1 = 0;

    @Test
    void exercise_design_reverse_engineering() throws InterruptedException
    {
        int tasksCount = 1_000_000;
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < tasksCount; i++)
        {
            executor.submit(() -> {
                counter1++;
            });
        }

        executor.awaitTermination(5, SECONDS);

        System.out.println(counter1);
    }
}
