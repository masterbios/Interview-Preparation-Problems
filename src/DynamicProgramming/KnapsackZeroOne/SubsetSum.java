package DynamicProgramming.KnapsackZeroOne;

public class SubsetSum {
    public boolean solve(int a[], int sum) {
        int n = a.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = false;
                else if (j == 0) dp[i][j] = true;
                else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= a[i - 1]) dp[i][j] |= dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
