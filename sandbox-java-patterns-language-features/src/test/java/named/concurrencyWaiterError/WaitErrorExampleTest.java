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
                lock.wait(); // ← why will throw exception?
            });


            // then
            assertThat(ex.getMessage(), equalTo("current thread is not owner")); // (is not an owner of what?);
        }
    }

    @Nested
    class Solution
    {
        private final Object lock = new Object();

        @Test
        void should_call_wait_normally() throws InterruptedException
        {
            // given
            synchronized (lock)
            {
                System.out.println("Entered sync block");
                // when
                lock.wait(5000); // how this is supposed to be used without timeouts?
                System.out.println("Will this be printed somewhen?");
            }
        }
    }
}