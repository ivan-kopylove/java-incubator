package leetcode.a2998;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;

class MySolutionRunnerTest
{
    @ParameterizedTest
    @CsvSource({
            "26,1,3",
            "54,2,4",
            "25,30,5",
            "3,1,2",
            "4,1,2",
            "8,2,3",
            "8,4,4",
    })
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
