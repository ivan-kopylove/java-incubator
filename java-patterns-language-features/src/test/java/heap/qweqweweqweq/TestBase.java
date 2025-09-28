package heap.qweqweweqweq;

import org.junit.jupiter.api.BeforeEach;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.EXAMPLE;
import static heap.cb2d.EducationalStrengthness.EXERCISE;
import static org.junit.jupiter.api.Assertions.fail;

public class TestBase
{
    @BeforeEach
    public void run()
    {
        if (EDUCATION_MODE == EXAMPLE)
        {
            fail("try to predict yourself first");
        }
    }
}
