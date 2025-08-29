package leetcode.a2998;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;

class MySolutionRunnerTest
{
    @ParameterizedTest
    @CsvSource({"26,1,3", "54,2,4",})
    void should_calculate_minimum(int x, int y, int expected)
    {
        // given
        int result = new MySolution().minimumOperationsToMakeEqual(x, y);

        // when

        // then
        assertThat(result, CoreMatchers.equalTo(expected));
    }
}
