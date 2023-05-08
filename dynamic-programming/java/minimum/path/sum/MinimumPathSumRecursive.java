package minimum.path.sum;

public class MinimumPathSumRecursive {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        if (grid[0].length == 1) {
            return grid[0][0];
        }

        minPath(grid, 0, 1);

        return grid[grid.length-1][grid[0].length-1];
    }

    private void minPath(int [][] grid, int r, int c) {
        if(c-1 < 0) {
            grid[r][c] = grid[r][c] + grid[r - 1][c];
        } else if(r-1 < 0) {
            grid[r][c] = grid[r][c] + grid[r][c - 1];
        } else {
            grid[r][c] = grid[r][c] + Math.min(grid[r - 1][c], grid[r][c - 1]);
        }

        if(c+1 < grid[0].length) {
            minPath(grid, r, c+1);
        } else if(r+1 < grid.length) {
            minPath(grid, r+1, 0);
        }
    }
}
