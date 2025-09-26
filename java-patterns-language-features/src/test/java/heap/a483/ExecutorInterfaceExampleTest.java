package heap.a483;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executor;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Facets:
///
/// - concurrency
class ExecutorInterfaceExampleTest
{
    @Test
    void reverse_engineer_hypothetical_design_of_the_example()
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
