package leetcode.L416;

import java.util.Arrays;

class Step90_Solution
{
    boolean canPartition(int[] nums)
    {
        int sum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        if (sum % 2 == 1)
        {
            return false;
        }

        int[][] dp = new int[nums.length + 1][sum / 2 + 1];

        for (int i = 0; i < dp.length; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return dfs(sum / 2, 0, nums, dp);
    }

    private boolean dfs(int halfSum, int i, int[] nums, int[][] dp)
    {
        if (halfSum == 0)
        {
            return true;
        }

        if (halfSum < 0 || i >= nums.length)
        {
            return false;
        }

        if (dp[i][halfSum] != -1)
        {
            return dp[i][halfSum] == 1 ? true : false;
        }

        boolean branch1 = dfs(halfSum - nums[i], i + 1, nums, dp);
        boolean branch2 = dfs(halfSum, i + 1, nums, dp);

        dp[i][halfSum] = branch1 || branch2 ? 1 : 0;
        return dp[i][halfSum] == 1 ? true : false;
    }
}