package DynamicProgramming.KnapsackZeroOne;

public class EqualSubsetSumPartitioning {

    public boolean solve(int a[]) {
        int sum = 0, n = a.length;
        for (int x : a) sum += x;
        if (sum % 2 != 0) return false;
        boolean dp[][] = new boolean[n + 1][sum / 2 + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = false;
                else if (j == 0) dp[i][j] = true;
                else {
                    if (a[i - 1] > j) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][sum / 2];
    }
}
