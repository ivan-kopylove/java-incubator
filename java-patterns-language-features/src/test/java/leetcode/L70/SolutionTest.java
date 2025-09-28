package leetcode.L70;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.EXAMPLE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// - [searchable problem definition](https://google.com/search?q=leetcode%2070)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+leetcode+70)
import heap.qweqweweqweq.TestBase;
class SolutionTest extends TestBase
{

    @ParameterizedTest
    @MethodSource("dataSet")
    void run_tests(int n, int expected)
    {
        if (EDUCATION_MODE == EXAMPLE)
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
}
