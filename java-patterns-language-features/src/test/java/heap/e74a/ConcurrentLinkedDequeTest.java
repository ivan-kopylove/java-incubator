package heap.e74a;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

import static java.util.concurrent.Executors.newFixedThreadPool;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import heap.qweqweweqweq.TestBase;

class ConcurrentLinkedDequeTest extends TestBase
{
    @Test
    void what_is_the_purpose_of_this_example() throws InterruptedException
    {
        // given
        var deque = new ConcurrentLinkedDeque<String>();
        var threadPool = newFixedThreadPool(200);

        // when
        IntStream.range(0, 10_000).forEach((value) -> {
            threadPool.submit(() -> {
                deque.add(String.valueOf(value));
            });
        });

        Thread.sleep(10_000);
        // then
        assertThat(deque.size(), equalTo(10_000));
    }
}
