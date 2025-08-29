package heap.e74a;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;

class ConcurrentLinkedQueTest
{
    @Test
    void what_is_the_purpose_of_this_example() throws InterruptedException
    {
        // given
        var result = new ConcurrentLinkedQueue<String>();
        var threadPool = newFixedThreadPool(200);

        // when
        IntStream.range(0, 10_000).forEach((value) -> {
            threadPool.submit(() -> {
                result.add(String.valueOf(value));
            });
        });

        // then
        Thread.sleep(10_000);
        MatcherAssert.assertThat(result.size(), CoreMatchers.equalTo(10_000));
    }
}
