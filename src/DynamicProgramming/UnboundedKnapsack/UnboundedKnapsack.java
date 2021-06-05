package DynamicProgramming.UnboundedKnapsack;

public class UnboundedKnapsack {
    public int solve(int weight, int wt[], int val[]) {
        int n = wt.length;
        int dp[] = new int[weight + 1];
        for (int i = 1; i <= weight; i++) {
            for (int j = 1; j <= n; j++) {
                if (wt[j - 1] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j - 1]] + val[j - 1]);
                }
            }
        }
        return dp[weight];
    }
}
