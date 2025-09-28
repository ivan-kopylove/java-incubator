package heap.ae47;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import heap.qweqweweqweq.TestBase;
class ClosureExerciseTest extends TestBase
{

    static TextProvider getProvider(int value)
    {
        value = 30; // why this line prevents from using value inside inner class?
        return new TextProvider()
        {
            @Override
            public int get()
            {
                //               return value;
                return 30;
            }
        };
    }

    @Test
    @Disabled
    public void exercise_design_reverse_engineering()
    {
        TextProvider provider = getProvider(15);
        assertEquals(15, provider.get());
    }

    @Test
    @Disabled
    public void exercise_design_reverse_engineering2()
    {
        TextProvider provider = getProvider(20);
        assertEquals(20, provider.get());
    }

    interface TextProvider
    {
        int get();
    }
}
