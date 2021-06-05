package DynamicProgramming.KnapsackZeroOne;

public class ClassicalZeroOneKnapsack {

    public int solveI(int val[], int wt[], int limit) {
        int n = val.length;
        int dp[][] = new int[n + 1][limit + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= limit; j++) {
                dp[i][j] = dp[i - 1][j];
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= limit; j++) {
                System.out.print(dp[i][j] + " ");
            } System.out.println();
        }
        return dp[n][limit];
    }

    int memo[][];

    public int solveR(int val[], int wt[], int limit) {
        int n = val.length;
        memo = new int[n + 1][limit + 1];
        return solve(n, val, wt, limit);
    }

    public int solve(int n, int val[], int wt[], int limit) {
        if (n <= 0) return 0;
        if (memo[n][limit] != 0) return memo[n][limit];
        int res = 0;
        if (wt[n - 1] <= limit) {
            res = val[n - 1] + solve(n - 1, val, wt, limit - wt[n - 1]);
        }
        res = Math.max(res, solve(n - 1, val, wt, limit));
        return memo[n][limit] = res;
    }
}
