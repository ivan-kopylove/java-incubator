package leetcode.L3186;

import java.util.LinkedList;
import java.util.List;

/// [502 / 554 testcases passed](https://leetcode.com/problems/maximum-total-damage-with-spell-casting/submissions/1756893038/?envType=problem-list-v2&envId=dynamic-programming)
class MySolution_502_554_casesPassed
{
    long maximumTotalDamage(int[] power)
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