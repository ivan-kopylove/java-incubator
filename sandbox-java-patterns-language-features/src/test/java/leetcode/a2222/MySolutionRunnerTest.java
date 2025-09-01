package leetcode.a2222;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class MySolutionRunnerTest
{
    @ParameterizedTest
    @CsvSource({
            "001101,6",
    })
    void should_calculate_minimum(String s, long expected)
    {
        // given
        Solution sut = new Solution();

        // when
        long result = sut.numberOfWays(s);

        // then
        assertThat(result, equalTo(expected));
    }
}
