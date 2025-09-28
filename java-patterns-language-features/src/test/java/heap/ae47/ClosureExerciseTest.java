package heap.ae47;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Make provider return a value passed from initial call
/// facets
/// - patterns
/// - closure
/// - koan
class ClosureExerciseTest
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
    public void exercise_reverse_engineering_design()
    {
        TextProvider provider = getProvider(15);
        assertEquals(15, provider.get());
    }

    @Test
    @Disabled
    public void exercise_reverse_engineering_design2()
    {
        TextProvider provider = getProvider(20);
        assertEquals(20, provider.get());
    }

    interface TextProvider
    {
        int get();
    }
}
