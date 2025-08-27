package heap.ee94;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * fiddling with a solution
 * <p>
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/solutions/6789775/beats-100-java-0ms-dp-solution/">6789775</a>
 */
public class Solution_6789775 {


    @Test
    public void run()
    {
        new Solution().minOperations(33);
    }
}

@SuppressWarnings("ALL")
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minOperations(int n) {
        return dp(n);
    }
    private int dp(int n) {

        if (n == 0) return 0;

        if ((n & (n - 1)) == 0) {
            memo.put(n, 1);
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int power = 1;
        while (power < n) {
            power <<= 1;
        }

        // by subtracting from the right side of the interavl - what does he do?
        // the leftover of subtraction - is what?
        int option1 = (int) dp(power - n);
        int option2 = (int) dp(n - (power >> 1));

        int minOps = 1 + Math.min(option1, option2);
        memo.put(n, minOps);
        return minOps;
    }

}