package heap.a976;

import org.junit.jupiter.api.Test;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.EXERCISE;
import static org.junit.jupiter.api.Assertions.fail;

class NullValueExamplesTest
{
    @Test
    void exercise_reverse_engineering_design()
    {
        if (EDUCATION_MODE == EXERCISE)
        {
            fail("try to predict yourself before running the assertion");
        }

        System.out.println(null == null);
    }
}
