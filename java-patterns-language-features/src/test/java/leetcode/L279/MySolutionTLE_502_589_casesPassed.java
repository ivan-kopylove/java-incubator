package leetcode.L279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MySolutionTLE_502_589_casesPassed
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

        Collections.reverse(options); // what if there no reverse?

        int result = dfs(n, options, 0, 0, new int[n + 1][n + 1]);

        if(result == Integer.MAX_VALUE)
        {
            return 1;
        }
        else
        {
            return result;
        }
    }

    int dfs(int n, List<Integer> options, int current, int step, int[][] dp)
    {
        if(current > n)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[current][step] != 0)
        {
            return dp[current][step];
        }

        if(current == n)
        {
            return step;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < options.size(); i++)
        {
            Integer x = options.get(i);
            
            min = Math.min(min, dfs(n, options, current + x, step + 1, dp));
        }

        dp[current][step] = min;
        return dp[current][step];
    }
}