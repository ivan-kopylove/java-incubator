package leetcode.a2998;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;

class MySolutionTest
{
    @ParameterizedTest
    @CsvSource({
            "26,1,3",
            "54,2,4",
    }
)
    void should_calculate_minimum(int x, int y, int expected)
    {
        // given
        int result = new MySolution().minimumOperationsToMakeEqual(x, y);

        // when

        // then
        assertThat(result, CoreMatchers.equalTo(expected));
    }
}

class MySolution
{
    public int minimumOperationsToMakeEqual(int x, int y)
    {
        return dfs(x, y);
    }

    int dfs(int x, int y)
    {
        if (x < y)
        {
            return y - x;
        }

        if (x == y)
        {
            return 0;
        }

        if (x - y <= 2)
        {
            return x - y;
        }


        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        int four = Integer.MAX_VALUE;
        int five = Integer.MAX_VALUE;
        int six = Integer.MAX_VALUE;
        int seven = Integer.MAX_VALUE;
        int eight = Integer.MAX_VALUE;

        if (x % 11 == 0)
        {
            one = dfs(x / 11, y);
        }

        if (x % 5 == 0)
        {
            two = dfs(x / 5, y);
        }


        return 1 + Math.min(one, two);
    }
}