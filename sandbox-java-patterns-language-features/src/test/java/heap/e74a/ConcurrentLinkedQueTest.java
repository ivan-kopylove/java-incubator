package heap.e74a;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class ConcurrentLinkedQueTest
{
    @Test
    void what_is_the_purpose_of_this_example() throws InterruptedException
    {
        // given
        var result = new ConcurrentLinkedQueue<String>();
        var threadPool = Executors.newFixedThreadPool(200);

        // when
        IntStream.range(0, 10_000).forEach((value) -> {
            threadPool.submit(() -> {
                result.add(String.valueOf(value));
            });
        });

        // then
        Thread.sleep(10_000);
        assertThat(result.size(), equalTo(10_000));
    }
}
