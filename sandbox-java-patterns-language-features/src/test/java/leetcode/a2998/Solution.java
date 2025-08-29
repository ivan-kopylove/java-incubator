package leetcode.a2998;

class Solution
{
    public int minimumOperationsToMakeEqual(int x, int y) {
        return dfs(x, y);
    }

    int dfs(int x, int y)
    {
        System.out.println(x);

        if(x < y)
        {
            return y-x;
        }

        if(x == y)
        {
            return 0;
        }

        if(x - y <= 3)
        {
            return x - y;
        }


        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        if(x % 11 == 0)
        {
            one = dfs(x / 11, y);
        }

        if(x % 5 == 0)
        {
            two = dfs(x / 5, y);
        }

        return 1 + Math.min(one, two);
    }

}