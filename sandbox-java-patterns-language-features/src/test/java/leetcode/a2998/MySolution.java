package leetcode.a2998;

import static org.hamcrest.MatcherAssert.assertThat;

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