package heap.a976;

import org.junit.jupiter.api.Test;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.junit.jupiter.api.Assertions.fail;

class NullValueExamplesTest
{
    @Test
    void what_will_be_printed()
    {
        if (EDUCATION_MODE == KOAN)
        {
            fail("try to predict yourself before running the assertion");
        }

        System.out.println(null == null);
    }
}
