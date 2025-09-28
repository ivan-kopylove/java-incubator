package leetcode.L416;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest
{
    @ParameterizedTest
    @MethodSource("dataSet")
    void foo(int[] input, boolean expected)
    {
        // given
        FixMissingSantiyCheckKoan sut = new FixMissingSantiyCheckKoan();

        // when
        boolean result = sut.canPartition(input);

        // then
        assertThat(result, equalTo(expected));
    }

    private static List<Arguments> dataSet()
    {
        // @formatter:off
        return List.of(
                arguments(new int[]{1, 5, 3}, false)
        );
        // @formatter:on
    }
}
