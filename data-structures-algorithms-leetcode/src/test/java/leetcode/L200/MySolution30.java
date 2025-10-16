package leetcode.L200;

class MySolution30
{
    int numIslands(char[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                dfs(i, j, grid, dp);
            }
        }

        return 0;
    }

    void dfs(int i, int j, char[][] grid, int[][] dp)
    {
//        if(grid[i][j] == ?) // what I am not interested in?
//        {
//            return;
//        }

        if(grid[i][j] == '1')
        {
//            dp[i][j] = ?;
        }

        dfs(i + 1, j, grid, dp);
        dfs(i - 1, j, grid, dp);
        // 2 more
    }

    
}
