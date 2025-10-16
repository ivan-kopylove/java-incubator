package heap.a3c9;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/// [source](https://github.com/search?q=NoPublishDemo&type=code)
public class NoPublishDemo extends TestBase
{
    private boolean stop = false;
    private boolean stopped = false;

    @Test
    void exercise_design_reverse_engineering1() throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            System.out.println("ConcurrencyCheckTask started!");

            while (!stop) {
            }

            stopped = true;
            System.out.println("ConcurrencyCheckTask stopped");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Set stop to true in main");
        stop = true;
        System.out.println("Exit main");
        Thread.sleep(10_000);
        assertThat(stopped, is(false)); // is that what might have been expected?
    }
}
