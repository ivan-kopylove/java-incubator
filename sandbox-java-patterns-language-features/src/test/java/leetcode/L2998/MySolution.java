package leetcode.L2998;

import java.util.Arrays;

/// - [problem definition](https://google.com/search?q=leetcode%202998)
/// - [garden](https://ivan-kopylove.github.io/leetcode/3a54)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+2998)
/// - [obsidian](obsidian://search?query=leetcode%202998)
class MySolution
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
        else if (shift >= 0 && shift < 5)
        {
            result = Math.min(result, 1 + dfs(x + 1, y, shift + 1, dp));
        }

        if (x % 5 == 0)
        {
            result = Math.min(result, 1 + dfs(x / 5, y, 0, dp));
        }
        else if (shift >= 0 && shift < 4)
        {
            result = Math.min(result, 1 + dfs(x + 1, y, shift + 1, dp));
        }

        if (shift > -5 && shift <= 0)
        {
            result = Math.min(result, 1 + dfs(x - 1, y, shift - 1, dp));
        }

        dp[x] = result;
        return dp[x];
    }
}