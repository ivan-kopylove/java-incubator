package leetcode.L241;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/// - [searchable problem definition](https://google.com/search?q=leetcode%20241)
/// - [garden](https://ivan-kopylove.github.io/leetcode/e5eb)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+241)
/// - [obsidian](obsidian://search?query=leetcode%20241)
class SolutionTest
{
    private static List<Arguments> dataSet()
    {
        // @formatter:off
        return List.of(
                       arguments("21-51-18-25-21-51-18-25-100+50+51", List.of(60, 60))
//                       arguments("21-51-18-25", List.of(60, 60))
//                       arguments("15*1*4", List.of(60, 60))
       // @formatter:on

        );
    }

    @ParameterizedTest
    @MethodSource("dataSet")
    void should_calculate_result(String input, List<Integer> expected)
    {
        // given
        PeekedAtSolution6634483 sut = new PeekedAtSolution6634483();

        // when
        List<Integer> result = sut.diffWaysToCompute(input);

        // then
        assertThat(result, equalTo(expected));
    }
}
