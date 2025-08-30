package leetcode.a2998;

import java.util.Arrays;

class Solution
{
    public int minimumOperationsToMakeEqual(int x, int y)
    {
        int[] dp = new int[x + 11];
        Arrays.fill(dp, -1);
        return dfs(x, y, 0, dp);
    }

    int dfs(int x, int y, int shift, int[] dp)
    {
        if (x <= y)
        {
            return y - x;
        }

        int result = Math.abs(x - y);

        if (x % 11 == 0)
        {
            result = Math.min(result, 1 + dfs(x / 11, y, 0, dp));
        }
        else if(shift > 0 && shift < 5)
        {
            result = Math.min(result, 1 + dfs(x + 1, y, shift + 1, dp));
        }

        if (x % 5 == 0)
        {
            result = Math.min(result, 1 + dfs(x / 5, y, 0, dp));
        }
        else if(shift > 0 && shift < 4)
        {
            result = Math.min(result, 1 + dfs(x + 1, y, shift + 1, dp));
        }

        if (shift == 0)
        {
            result = Math.min(result, 1 + dfs(x - 1, y, shift - 1, dp));
            result = Math.min(result, 1 + dfs(x + 1, y, shift + 1, dp));
        }

            result = Math.min(result, 1 + dfs(x - 1, y, shift - 1, dp));


        dp[x] = result;
        return dp[x];
    }
}