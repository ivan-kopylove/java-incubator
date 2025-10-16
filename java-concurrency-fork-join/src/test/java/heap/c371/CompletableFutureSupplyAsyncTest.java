package heap.c371;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.github.ivan.kopylove.commons.testing.TestBase;
class CompletableFutureSupplyAsyncTest extends TestBase
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

        assertThat(stringCompletableFuture.get(), equalTo("world"));
    }
}
