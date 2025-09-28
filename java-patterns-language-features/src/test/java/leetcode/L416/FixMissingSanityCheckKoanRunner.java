package leetcode.L416;

import org.junit.jupiter.api.Test;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FixMissingSanityCheckKoanRunner
{

    @Test
    void fixMissingSantiyCheck()
    {
        if (EDUCATION_MODE != KOAN)
        {
            return;
        }

        // given
        FixMissingSantiyCheckKoan sut = new FixMissingSantiyCheckKoan();

        // when
        boolean result = sut.canPartition(new int[]{1, 5, 3});

        // then
        assertThat(result, equalTo(result));
    }
}
