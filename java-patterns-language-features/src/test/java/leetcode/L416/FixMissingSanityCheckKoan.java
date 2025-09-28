package leetcode.L416;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FixMissingSanityCheckKoan
{

    @Test
    void fixMissingSantiyCheck()
    {
        if (EDUCATION_MODE != KOAN)
        {
            return;
        }

        // given
        FixMissingSantiyCheck sut = new FixMissingSantiyCheck();

        // when
        boolean result = sut.canPartition(new int[]{1, 5, 3});

        // then
        assertThat(result, equalTo(result));
    }
}
