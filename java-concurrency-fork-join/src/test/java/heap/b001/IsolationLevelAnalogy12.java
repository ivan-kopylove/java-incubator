package heap.b001;

import org.junit.jupiter.api.Test;

/// an example of what isolation level?
class IsolationLevelAnalogy12
{
    private int cell = 0;

    private ThreadLocal<Integer> copy = new ThreadLocal<Integer>(); // what if there were no ThreadLocal here?

    @Test
    void exercise_design_reverse_engineering1()
    {

        for(int i = 0; i < 10_000; i++)
        {
            new Thread(() -> { // floor is lava, thread is transaction
                // transaction takes copy of data inside
                copy.set(cell);

                sleep();
                Integer a = copy.get();
                a++; // an operation
                copy.set(a);

                cell = copy.get(); // commit. Where one more hidden commit here?
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
