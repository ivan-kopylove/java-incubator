package heap.a67b;

import org.junit.jupiter.api.Test;

import heap.qweqweweqweq.TestBase;
class WhyAlwaysFiveExerciseTest extends TestBase
{
    int i = 0;

    @Test
    void exercise_design_reverse_engineering()
    {
        i++;
        if (i < 5)
        {
            exercise_design_reverse_engineering();
        }
        System.out.println(i);
    }
}
