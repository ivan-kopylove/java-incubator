package heap.b001;

import org.junit.jupiter.api.Test;

/// an example of what isolation level?
class IsolationLevelAnalogy11
{
    private volatile int cell = 0;

    @Test
    void exercise_design_reverse_engineering1()
    {
        for(int i = 0; i < 10_000; i++)
        {
            new Thread(() -> { // floor is lava, thread is transaction
                // transaction takes copy of data inside
                int threadConfinedCopy = cell;

                sleep();
                threadConfinedCopy++; // operation 1
                threadConfinedCopy++; // operation 2

                cell = threadConfinedCopy; // commit. Where one more hidden commit here?
            }).start();
        }

        // then
        System.out.println(cell);
    }

    private static void sleep()
    {
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
