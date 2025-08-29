package leetcode.a2998;

class Solution
{
    public int minimumOperationsToMakeEqual(int x, int y)
    {
        return dfs(x, y, 0);
    }

    int dfs(int x, int y, int shift)
    {
        if (x == y)
        {
            return 0;
        }

        if (x < y)
        {
            return y - x;
        }



        int call1 = Integer.MAX_VALUE - 50000;
        int call2 = Integer.MAX_VALUE - 50000;
        int call3 = Integer.MAX_VALUE - 50000;
        int call4 = Integer.MAX_VALUE - 50000;
        int call5 = Integer.MAX_VALUE - 50000;
        int call6 = Integer.MAX_VALUE - 50000;

        if (x % 11 == 0)
        {
            call1 = dfs(x / 11, y, 0);
        }

        if (x % 5 == 0)
        {
            call2 = dfs(x / 5, y, 0);
        }

        if (shift == 0)
        {
            call3 = dfs(x - 1, y, shift - 1);
            call4 = dfs(x + 1, y, shift + 1);

        }
        else if(shift > 0 && shift < 7)
        {
            call5 = dfs(x + 1, y, shift + 1);
        }
        else if (shift < 0 && shift > -10000)
        {
            call6 = dfs(x - 1, y, shift - 1);
        }


        return 1 + Math.min(call1, Math.min(call2, Math.min(call3, Math.min(call4, Math.min(call5, call6)))));
    }
}