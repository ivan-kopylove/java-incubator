package leetcode.L990;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// @see <a href="https://www.google.com/search?q=leetcode 990">problem definition</a>
/// @see <a href="https://ivan-kopylove.github.io/leetcode/88a6">garden</a>
/// @see <a href="https://github.com/search?q=user%3Aivan-kopylove+990">github</a>
/// @see <a href="obsidian://search?query=leetcode 990">obsidian</a>
class MySolutionRunnerTest
{
    @ParameterizedTest
    @MethodSource("dataSet")
    void should_calculate_minimum(String[] s, boolean expected)
    {
        // given
        Solution sut = new Solution();

        // when
        boolean result = sut.equationsPossible(s);

        // then
        assertThat(result, equalTo(expected));
    }

    private static List<Arguments> dataSet()
    {
        return List.of(
                arguments(new String[]{"a!=a"}, false),
                arguments(new String[]{"c==c","b==d","x!=z"}, true),
                arguments(new String[]{"a==b","b==c", "c!=a"}, false),
                arguments(new String[]{"b!=a","c==a"}, true),
                arguments(new String[]{"a==b","e==c","b==c","a!=e"}, false),
                arguments(new String[]{"a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"}, false)

        );
    }
}
