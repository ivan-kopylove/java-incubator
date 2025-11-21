package heap.a67b;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

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
