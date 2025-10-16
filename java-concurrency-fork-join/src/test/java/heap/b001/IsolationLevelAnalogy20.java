package heap.b001;

import org.junit.jupiter.api.Test;

/// an example of what isolation level?
class IsolationLevelAnalogy20
{
    private int cell = 0;

    @Test
    void exercise_design_reverse_engineering1()
    {
        for(int i = 0; i < 10_000; i++)
        {
            new Thread(() -> { // floor is lava, thread is transaction
                cell++; // operation 1
                sleep();
                // other threads now see what and because of this what level of isolation it is?
                cell++; // operation 2 - let's imagine this is a final commit

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
