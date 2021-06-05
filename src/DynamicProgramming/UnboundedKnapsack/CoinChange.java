package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class CoinChange {
    final int INF = (1 << 29);

    public int solve(int coins, int changes[]) {
        int dp[] = new int[coins + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= coins; i++) {
            for (int x : changes) {
                if (i >= x) dp[i] = Math.min(dp[i], dp[i - x] + 1);
            }
        }

        return dp[coins];
    }
}
