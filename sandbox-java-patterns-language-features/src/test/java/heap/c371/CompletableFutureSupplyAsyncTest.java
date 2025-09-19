package heap.c371;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class CompletableFutureSupplyAsyncTest
{

    @Test
    void exception()
    {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("hello");
        });
        assertThrows(RuntimeException.class, () -> {
            try
            {
                stringCompletableFuture.get();
            }
            catch (ExecutionException e)
            {
                throw e.getCause();
            }
        });
    }

    @Test
    void return_value() throws ExecutionException, InterruptedException
    {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "world");

         if (EDUCATION_MODE == KOAN)
        {
            fail("try to predict yourself before running the assertion");
        }
        assertThat(stringCompletableFuture.get(), equalTo("world"));
    }
}
