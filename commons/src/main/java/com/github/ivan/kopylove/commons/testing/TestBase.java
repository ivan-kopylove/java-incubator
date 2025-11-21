package com.github.ivan.kopylove.commons.testing;

import org.junit.jupiter.api.BeforeEach;

import static com.github.ivan.kopylove.commons.testing.EducationalStrengthness.EDUCATION_MODE;
import static com.github.ivan.kopylove.commons.testing.EducationalStrengthness.EXERCISE;
import static org.junit.jupiter.api.Assertions.fail;

public class TestBase
{
    @BeforeEach
    public void predictYourselfFirst()
    {
        if (EDUCATION_MODE == EXERCISE)
        {
            fail("try to predict yourself first");
        }
    }
}
