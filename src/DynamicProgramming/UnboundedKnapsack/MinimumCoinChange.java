package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class MinimumCoinChange {

    final int INF = (1 << 29);

    public int solve(int coins[], int vals) {
        int dp[] = new int[vals + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= vals; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[vals];
    }

}
