package named.concurrencyWaiterError;

// Example 1: Basic Illegal Monitor State (Run to see error)

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WaitErrorExampleTest
{
    @Nested
    class Problem
    {
        @Test
        void should_throw_because_monitor_is_not_locked()
        {
            // given
            Object lock = new Object();

            // when
            IllegalMonitorStateException ex = assertThrows(IllegalMonitorStateException.class, () -> {
                lock.wait(); // ← This will throw exception
            });


            // then
            assertThat(ex.getMessage(), equalTo("Current thread is not owner (of what?)"));
        }
    }

    @Nested
    class Solution
    {
        @Test
        void should_call_wait_normally() throws InterruptedException
        {
            // given
            Object lock = new Object();
            synchronized (lock)
            {
                System.out.println("Entered sync block");
                // when
                lock.wait();
                System.out.println("Will this be printed somewhen?");
            }
        }
    }
}