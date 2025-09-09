package leetcode.L241;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// @see <a href="https://google.com/search?q=leetcode 241">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/190b">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+241">github</a>
/// @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/1764655146/">my submission</a>
/// @see <a href="obsidian://search?query=leetcode 241">obsidian</a>
class MySolutionRunnerTest
{
    @ParameterizedTest
    @MethodSource("dataSet")
    void should_calculate_minimum(String input, List<Integer> expected)
    {
        // given
        Solution6634483 sut = new Solution6634483();

        // when
        List<Integer> result = sut.diffWaysToCompute(input);

        // then
        assertThat(result, equalTo(expected));
    }

    private static List<Arguments> dataSet()
    {
        return List.of(//
                       arguments("21-51-18-25", List.of(60,60)),//
                       arguments("15*1*4", List.of(60,60)) //

        );
    }
}
