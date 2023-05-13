package minimum.path.sum;

public class MinimumPathSumIterative {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        if (grid[0].length == 1) {
            return grid[0][0];
        }

        for(int i = 1; i<grid[0].length; i++) {
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }

        for(int i = 1; i<grid.length; i++) {
            grid[i][0] = grid[i][0] + grid[i-1][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int x = 1; x < grid[0].length; x++) {
                grid[i][x] = grid[i][x] + Math.min(grid[i - 1][x], grid[i][x - 1]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}

