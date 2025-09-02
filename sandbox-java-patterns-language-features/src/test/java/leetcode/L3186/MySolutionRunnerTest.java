package leetcode.L3186;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/// @see <a href="https://www.google.com/search?q=leetcode 3186">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/XXXXXXXXXXXX">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+3186">github</a>
/// @see <a href="obsidian://search?query=leetcode 3186">obsidian</a>
class MySolutionRunnerTest
{
    @ParameterizedTest
    @MethodSource("palindromeCombos")
    void should_calculate_minimum(int[] input, long expected)
    {
        // given
        Solution sut = new Solution();

        // when
        long result = sut.maximumTotalDamage(input);

        // then
        assertThat(result, equalTo(expected));
    }

    public static Stream<Arguments> palindromeCombos()
    {
        return Stream.of(//
                         Arguments.of(new int[]{7, 1, 6, 6}, 13), //
                         Arguments.of(new int[]{1, 1, 3, 4}, 6) //
        );
    }
}
