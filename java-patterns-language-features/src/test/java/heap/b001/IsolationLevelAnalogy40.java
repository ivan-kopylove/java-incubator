package heap.b001;

import org.junit.jupiter.api.Test;

/// an example of what isolation level?
public class IsolationLevelAnalogy40
{
    private int    cell = 0;
    private Object lock = new Object();

    @Test
    void exercise_design_reverse_engineering1()
    {
        for(int i = 0; i < 100_000; i++)
        {
            // floor is lava, thread is transaction
            new Thread(() -> {
                synchronized(lock)
                {
                    cell++;
                }
            }).start();
        }

        // then
        System.out.println(cell);
    }
}
