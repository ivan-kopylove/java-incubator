package leetcode.L200;

class MySolution21
{
    public int numIslands(char[][] grid) {

        // what if there is no this extra data structure that hold, btw, what?
        // why this called dp?
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
        if(grid[i][j] == '1')
        {
            // where I guaranteed came from? what should happen here?
        }

        dfs(i + 1, j, grid, dp); // how do I usually express steps simulation - down, up, etc?
    }

    
}
