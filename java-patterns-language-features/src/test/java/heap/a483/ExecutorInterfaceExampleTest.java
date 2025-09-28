package heap.a483;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;

import static org.junit.jupiter.api.Assertions.assertEquals;


///
/// - concurrency
import com.github.ivan.kopylove.commons.testing.TestBase;
class ExecutorInterfaceExampleTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        Executor executor = new Executor()
        {
            @Override
            public void execute(Runnable runnable)
            {
                runnable.run();
            }
        };
        assertEquals("main", Thread.currentThread().getName());
        executor.execute(() -> assertEquals("main", Thread.currentThread().getName()));
    }
}
