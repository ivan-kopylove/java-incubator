package leetcode.L70;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.github.ivan.kopylove.commons.testing.EducationalStrengthness.EDUCATION_MODE;
import static com.github.ivan.kopylove.commons.testing.EducationalStrengthness.FAMILIARIZE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest extends TestBase
{

    private static List<Arguments> dataSet()
    {
        // @formatter:off
        return List.of(
                arguments(2, 2),
                arguments(3, 3),
                arguments(9, 55)
        );
        // @formatter:on
    }

    @ParameterizedTest
    @MethodSource("dataSet")
    void run_tests(int n, int expected)
    {
        if (EDUCATION_MODE == FAMILIARIZE)
        {
            return;
        }
        // given
        Exercise sut = new Exercise();

        // when
        long result = sut.climbStairs(n);

        // then
        assertThat(result, equalTo(expected));
    }
}
