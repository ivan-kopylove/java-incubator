package leetcode.L200;

class MySolutionFinal
{
    int numIslands(char[][] grid)
    {

        int[][] dp = new int[grid.length][grid[0].length];

        int current = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1' && dp[i][j] == 0)
                {
                    current++;
                }
                dfs(i, j, current, grid, dp);
            }
        }

        return current;
    }

    void dfs(int i, int j, int current, char[][] grid, int[][] dp)
    {
        if (i < 0)
        {
            return;
        }

        if (j < 0)
        {
            return;
        }

        if (grid.length == i)
        {
            return;
        }

        if (grid[i].length == j)
        {
            return;
        }

        if (grid[i][j] == '0')
        {
            return;
        }

        if (dp[i][j] != 0)
        {
            return;
        }

        if (grid[i][j] == '1')
        {
            dp[i][j] = current;
        }

        dfs(i + 1, j, current, grid, dp);
        dfs(i - 1, j, current, grid, dp);
        dfs(i, j + 1, current, grid, dp);
        dfs(i, j - 1, current, grid, dp);
    }
}
