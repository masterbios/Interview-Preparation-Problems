package DynamicProgramming.UnboundedKnapsack;

public class RodCutting {

    public int solve(int prices[], int length) {
        int n = prices.length;
        int dp[] = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + prices[j - 1]);
            }
        }
        return dp[length];
    }
}
