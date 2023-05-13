package unique.paths;

/****
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 */

public class UniquePathSolution {

    public long uniquePaths(int m, int n) {
        if(m == 1 || n == 1) {
            return 1;
        }

        long[][] memo = new long[m][n];
        memo[0][0] = 0;
        for(int i = 1; i<n; i++) memo[0][i] = 1;
        for(int i = 1; i<m; i++) memo[i][0] = 1;

        uniquePath(memo, 1, 1);

        return memo[m-1][n-1];
    }

    private void uniquePath(long[][] memo, int m, int n) {
        memo[m][n] = memo[m - 1][n] + memo[m][n - 1];
        if(n+1 < memo[0].length) {
            uniquePath(memo, m, n+1);
        } else if(m+1 < memo.length) {
            uniquePath(memo, m+1, 1);
        }
    }
}
