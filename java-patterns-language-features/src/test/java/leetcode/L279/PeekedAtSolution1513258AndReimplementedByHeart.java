package leetcode.L279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PeekedAtSolution1513258AndReimplementedByHeart
{
    public int numSquares(int n) {

        List<Integer> options = new ArrayList<>();
        options.add(1);

        for(int i = 2; i < n / 2 + 1; i++)    
        {
            if(i * i > n)
            {
                break;
            }
            options.add(i * i);
            System.out.println(i * i);
        }

        Collections.reverse(options); // what if there is no reverse?

        int result = dfs(n, options, new int[n + 1]);

        if(result == Integer.MAX_VALUE)
        {
            return 1;
        }
        else
        {
            return result;
        }
    }

    private int dfs(int n, List<Integer> options, int[] dp)
    {
        if(n < 0)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[n] != 0)
        {
            return dp[n];
        }

        if(n == 0)
        {
            return 0;
        }

        int min = n;
        for(int i = 0; i < options.size(); i++)
        {
            Integer x = options.get(i);
            
            min = Math.min(min, dfs(n - x, options, dp));
        }

        dp[n] = min + 1;
        return dp[n];
    }
}