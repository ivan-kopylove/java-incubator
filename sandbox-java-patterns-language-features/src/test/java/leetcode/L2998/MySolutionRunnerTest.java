package leetcode.L2998;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;

/// @see <a href="https://www.google.com/search?q=leetcode 2998">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/3a54">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+2998">github</a>
/// @see <a href="obsidian://search?query=leetcode 2998">obsidian</a>
class MySolutionRunnerTest
{
    @ParameterizedTest
    @CsvSource({"33,25,8", "9994,1111,208", "9996,909,4", "329,57,11", "21,12,9", "9420,8299,1121", "967,759,208", "89,57,32", "17,9,8", "16,9,7", "11,6,5", "14,2,3", "4,1,2", "26,1,3", "54,2,4", "25,30,5", "3,1,2", "8,2,3", "8,4,4", "10000,1,8",})
    void should_calculate_minimum(int x, int y, int expected)
    {
        // given
        Solution sut = new Solution();

        // when
        int result = sut.minimumOperationsToMakeEqual(x, y);

        // then
        assertThat(result, CoreMatchers.equalTo(expected));
    }
}
