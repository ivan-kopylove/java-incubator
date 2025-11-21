package leetcode.L416;

class Step20_CollapseDuplicatedRecursionExercise
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

        return dfs(sum / 2, 0, nums, true);
    }

    private boolean dfs(int halfSum, int i, int[] nums, boolean take)
    {
        if (halfSum == 0)
        {
            return true;
        }

        if (halfSum < 0 || i >= nums.length)
        {
            return false;
        }

        boolean result = false;
        if (take)
        {
            result = dfs(halfSum - nums[i], i + 1, nums, true);
            if (result)
            {
                return true;
            }

            result = dfs(halfSum - nums[i], i + 1, nums, false);
            if (result)
            {
                return true;
            }
        }
        else
        {
            result = dfs(halfSum, i + 1, nums, false);
            if (result)
            {
                return true;
            }
            result = dfs(halfSum, i + 1, nums, true);
            if (result)
            {
                return true;
            }
        }

        return false;
    }
}