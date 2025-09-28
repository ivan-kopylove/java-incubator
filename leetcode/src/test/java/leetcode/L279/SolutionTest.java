package leetcode.L279;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.github.ivan.kopylove.commons.testing.TestBase;
class SolutionTest extends TestBase
{
    @ParameterizedTest
    @MethodSource("dataSet")
    void run_tests(int n, int expected)
    {
        // given
        PeekedAtSolution1513258AndReimplementedByHeart sut = new PeekedAtSolution1513258AndReimplementedByHeart();

        // when
        int result = sut.numSquares(n);

        // then
        assertThat(result, equalTo(expected));
    }

    private static List<Arguments> dataSet()
    {
        // @formatter:off
        return List.of(
                arguments(12, 3),
                arguments(13, 2),
                arguments(7168, 4)
        );
        // @formatter:on
    }
}
