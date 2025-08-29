package leetcode.a2998;

class Solution
{
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y > x)
        {
            return y - x;
        }

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

        if(x - y <= 2)
        {
            return x - y;
        }


        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        int four = Integer.MAX_VALUE;
        int five = Integer.MAX_VALUE;
        int six = Integer.MAX_VALUE;
        int seven = Integer.MAX_VALUE;
        int eight = Integer.MAX_VALUE;

        if(x % 11 == 0)
        {
            one = dfs(x / 11, y);
        }

        if(x % 5 == 0)
        {
            two = dfs(x / 5, y);
        }
        else
        {
            if(x % 5 >= 3)
            {
                three = dfs(x + 1, y);
            }
            else
            {
                four = dfs(x - 1, y);
            }
        }

        return 1 + Math.min(one, Math.min(two, Math.min(three, Math.min(four, Math.min(five, Math.min(six, Math.min(seven, eight)))))));
    }

}