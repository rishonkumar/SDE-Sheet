package Arrays3;

public class GridUniquePaths {

    /*
    TC - exponential
*/
    public int uniquePathsRC(int m, int n) {

        return solve(0, 0, m, n);
    }


    int solve(int i, int j, int m, int n) {

        //Base case
        if (i == m - 1 && j == n - 1) return 1;

        //outside boundary
        if (i >= m || j >= n) return 0;

        //move right and down
        return solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
    }

    /*
    Overlapping Subproblems -> USE DP
    TC, SC - O(n*m)
*/
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        solve(0, 0, m, n, dp);
        return dp[0][0];
    }


    int solve(int i, int j, int m, int n, int[][] dp) {

        //Base case
        if (i == m - 1 && j == n - 1) return 1;

        //outside boundary
        if (i >= m || j >= n ) return 0;

        if (dp[i][j] != 0) return dp[i][j];

            //move right and down
        else  return dp[i][j] = solve(i + 1, j, m, n, dp) + solve(i, j + 1, m, n, dp);
    }

}
