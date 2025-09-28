package heap.a67b;

import org.junit.jupiter.api.Test;

class WhyAlwaysFiveExerciseTest
{
    int i = 0;

    @Test
    void exercise_reverse_engineering_design()
    {
        i++;
        if (i < 5)
        {
            exercise_reverse_engineering_design();
        }
        System.out.println(i);
    }
}
