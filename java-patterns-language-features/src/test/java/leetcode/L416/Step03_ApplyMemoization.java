package leetcode.L416;

class Step03_ApplyMemoization
{
    public boolean canPartition(int[] nums)
    {
        int sum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        if(sum % 2 == 1)
        {
            return false;
        }

        return dfs(sum / 2, 0, nums);
    }

    private boolean dfs(int halfSum, int i, int[] nums)
    {
        if (halfSum == 0)
        {
            return true;
        }

        if (halfSum < 0 || i >= nums.length)
        {
            return false;
        }

        boolean branch1 = dfs(halfSum - nums[i], i + 1, nums);
        boolean branch2 = dfs(halfSum,           i + 1, nums);

        return branch1 || branch2;
    }
}