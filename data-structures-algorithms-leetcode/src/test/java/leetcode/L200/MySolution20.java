package leetcode.L200;

class MySolution20
{
    int numIslands(char[][] grid) {

        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                dfs(i, j, grid);
            }
        }

        return 0;
    }

    void dfs(int i, int j, char[][] grid)
    {
        if(grid[i][j] == '1')
        {
            // where I guaranteed came from? what should happen here?
        }

        dfs(i + 1, j, grid); // how to express left, down, up?
    }

    
}
