package leetcode.L3186;

import java.util.LinkedList;
import java.util.List;

/// [TLE](https://leetcode.com/problems/maximum-total-damage-with-spell-casting/submissions/1756923231/)
///
/// - [problem definition](https://google.com/search?q=leetcode%203186)
/// - [garden](https://ivan-kopylove.github.io/leetcode/b531)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+3186)
/// - [obsidian](obsidian://search?query=leetcode%203186)
class MySolutionTLE
{
    public long maximumTotalDamage(int[] power)
    {
        return dfs(0, 0, power, new LinkedList<>());
    }

    private int dfs(int currentSum, int i, int[] power, List<Integer> used)
    {
        if (i >= power.length)
        {
            return currentSum;
        }
        int value = power[i];

        int max = 0;

        max = Math.max(max, dfs(currentSum, i + 1, power, used));

        if (used.contains(value - 1) || //
            used.contains(value - 2) || //
            used.contains(value + 1) || //
            used.contains(value + 2))
        {
            max = Math.max(max, dfs(currentSum, i + 1, power, used));
        }
        else
        {
            used.add(value);
            max = Math.max(max, dfs(currentSum + value, i + 1, power, used));
            used.remove((Integer) value);
        }

        if (!used.contains(value))
        {
            max = Math.max(max, dfs(currentSum, i + 1, power, used));
        }

        return max;
    }
}