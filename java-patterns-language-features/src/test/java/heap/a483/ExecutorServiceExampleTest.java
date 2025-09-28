package heap.a483;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertTrue;


import com.github.ivan.kopylove.commons.testing.TestBase;
class ExecutorServiceExampleTest extends TestBase
{

    @Test
    void exercise_design_reverse_engineering() throws InterruptedException
    {
        AtomicBoolean called = new AtomicBoolean(false);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> {
            called.set(true);
            System.out.println(Thread.currentThread().getName());
        });
        executor.close();

        Thread.sleep(50);
        assertTrue(called.get());
    }
}
