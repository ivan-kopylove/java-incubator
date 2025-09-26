package leetcode.L70;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.EXAMPLE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// - [searchable problem definition](https://google.com/search?q=leetcode%203186)
/// - [garden](https://ivan-kopylove.github.io/leetcode/b531)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+3186)
/// - [obsidian](obsidian://search?query=leetcode%203186)
class SolutionTest
{

    @ParameterizedTest
    @MethodSource("dataSet")
    void solution70(int n, int expected)
    {
        if (EDUCATION_MODE == EXAMPLE)
        {
            return;
        }

        // given
        Solution sut = new Solution();

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
