package leetcode.L2571;

import java.util.HashMap;
import java.util.Map;

/// - [peeked at solution](https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/solutions/6789775/beats-100-java-0ms-dp-solution/)
///
/// - [searchable problem definition](https://google.com/search?q=leetcode%202571)
/// - [garden](https://ivan-kopylove.github.io/leetcode/0c78)
/// - [github](https://github.com/search?q=user%3Aivan-kopylove+leetcode+2571)
/// - [obsidian](obsidian://search?query=leetcode%202571)
class PeekedAtSolution6789775
{

    Map<Integer, Integer> memo = new HashMap<>(); // what if it was an array?

    public int minOperations(int n)
    {
        return dp(n);
    }

    private int dp(int n)
    {

        if (n == 0)
        {
            return 0;
        }

        if ((n & (n - 1)) == 0)
        {
            memo.put(n, 1);
            return 1;
        }

        if (memo.containsKey(n))
        {
            return memo.get(n);
        }

        int power = 1;
        while (power < n)
        {
            power <<= 1;
        }

        // by subtracting from the right side of the interval - what does he do?
        // the leftover of subtraction - is what?
        int option1 = (int) dp(power - n);
        // by subtracting left from current side of the interval - what does he do?
        int option2 = (int) dp(n - (power >> 1));

        int minOps = 1 + Math.min(option1, option2);
        memo.put(n, minOps);
        return minOps;
    }
}
