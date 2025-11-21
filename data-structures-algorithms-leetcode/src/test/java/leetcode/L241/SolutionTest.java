package leetcode.L241;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest extends TestBase
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
    @Disabled
    void exercise_design_reverse_engineering(String input, List<Integer> expected)
    {
        // given
        PeekedAtSolution6634483 sut = new PeekedAtSolution6634483();

        // when
        List<Integer> result = sut.diffWaysToCompute(input);

        // then
        assertThat(result, equalTo(expected));
    }
}
