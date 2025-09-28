package heap.b33b;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.EXERCISE;
import static org.junit.jupiter.api.Assertions.fail;

class VolatileTest
{
    private static volatile int counter1 = 0;

    @Test
    void exercise_design_reverse_engineering() throws InterruptedException
    {
        int tasksCount = 100_000;
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
        if (EDUCATION_MODE == EXERCISE)
        {
            fail("try to predict yourself before running the assertion");
        }

        System.out.println(counter1);
    }
}
