package leetcode.L279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PeekedAtSolution1513258AndReimplementedByHeart
{
    int numSquares(int n)
    {

        List<Integer> options = new ArrayList<>();
        options.add(1);

        for (int i = 2; i < n / 2 + 1; i++)
        {
            if (i * i > n)
            {
                break;
            }
            options.add(i * i);
        }

        Collections.reverse(options); // what if there is no reverse?

        int result = dfs(n, options, new int[n + 1]);

        if (result == Integer.MAX_VALUE)
        {
            return 1;
        }
        else
        {
            return result;
        }
    }

    private int dfs(int current, List<Integer> options, int[] dp)
    {
        if (current < 0)
        {
            return Integer.MAX_VALUE;
        }

        if (dp[current] != 0)
        {
            return dp[current];
        }

        if (current == 0)
        {
            return 0;
        }

        int min = current;
        for (int i = 0; i < options.size(); i++)
        {
            Integer x = options.get(i);

            min = Math.min(min, dfs(current - x, options, dp));
        }

        dp[current] = min + 1;
        return dp[current];
    }
}