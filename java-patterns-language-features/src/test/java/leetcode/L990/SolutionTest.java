package leetcode.L990;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// - [searchable problem definition](https://google.com/search?q=leetcode%20990)
/// - [garden](https://ivan-kopylove.github.io/leetcode/88a6)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+990)
/// - [obsidian](obsidian://search?query=leetcode%20990)
class SolutionTest
{
    private static List<Arguments> dataSet()
    {
        // @formatter:off
        return List.of(
                arguments(new String[]{"a!=a"}, false),
                arguments(new String[]{"c==c","b==d","x!=z"}, true),
                arguments(new String[]{"a==b","b==c", "c!=a"}, false),
                arguments(new String[]{"b!=a","c==a"}, true),
                arguments(new String[]{"a==b","e==c","b==c","a!=e"}, false),
                arguments(new String[]{"a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"}, false)
        // @formatter:on

        );
    }

    @ParameterizedTest
    @MethodSource("dataSet")
    void reverse_engineer_hypothetical_design_of_the_example(String[] s, boolean expected)
    {
        // given
        MySolution_181_181_casesPassed sut = new MySolution_181_181_casesPassed();

        // when
        boolean result = sut.equationsPossible(s);

        // then
        assertThat(result, equalTo(expected));
    }
}
