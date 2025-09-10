package leetcode.L3186;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// - [problem definition](https://google.com/search?q=leetcode%203186)
/// - [garden](https://ivan-kopylove.github.io/leetcode/b531)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+3186)
/// - [obsidian](obsidian://search?query=leetcode%203186)
class MySolutionRunnerTest
{
    @ParameterizedTest
    @MethodSource("dataSet")
    void should_calculate_result(int[] input, long expected)
    {
        // given
        Solution sut = new Solution();

        // when
        long result = sut.maximumTotalDamage(input);

        // then
        assertThat(result, equalTo(expected));
    }

    private static List<Arguments> dataSet()
    {
        return List.of(//

                       arguments(new int[]{7, 1, 6, 3}, 10), //
                       arguments(new int[]{7, 1, 6, 6}, 13), //
                       arguments(new int[]{1, 1, 3, 4}, 6), //
                       arguments(new int[]{23, 10, 9, 34, 6, 34, 4, 20, 7, 6, 34, 27, 17, 12, 11, 11, 17, 21, 8, 21, 22, 22, 29, 7, 14, 8, 25, 10, 9, 22, 27, 23, 6, 16, 23, 15, 10, 30, 21, 4, 26, 11, 32, 18, 3, 24, 11, 13, 23, 20}, 10) //
        );
    }
}
