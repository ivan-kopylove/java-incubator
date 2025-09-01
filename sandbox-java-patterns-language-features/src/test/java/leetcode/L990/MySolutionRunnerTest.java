package leetcode.L990;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/// @see <a href="https://www.google.com/search?q=leetcode 990">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/88a6">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+990">github</a>
/// @see <a href="obsidian://search?query=leetcode 990">obsidian</a>
class MySolutionRunnerTest
{
    @ParameterizedTest
    @MethodSource("palindromeCombos")
    void should_calculate_minimum(String[] s, boolean expected)
    {
        // given
        Solution sut = new Solution();

        // when
        boolean result = sut.equationsPossible(s);

        // then
        assertThat(result, equalTo(expected));
    }

    public static Stream<Arguments> palindromeCombos()
    {
        return Stream.of(
                Arguments.of(new String[]{"a!=a"}, false),
                Arguments.of(new String[]{"c==c","b==d","x!=z"}, false),
                Arguments.of(new String[]{"a==b","b==c", "c!=a"}, false),
                Arguments.of(new String[]{"b!=a","c==a"}, true),
                Arguments.of(new String[]{"a==b","e==c","b==c","a!=e"}, false),
                Arguments.of(new String[]{"a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"}, false)

        );
    }
}
