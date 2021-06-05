package DynamicProgramming.UnboundedKnapsack;

import java.util.Arrays;

public class MaximumRibbonCutting {

    final int INF = Integer.MIN_VALUE;

    public int solve(int ribbons[], int length) {
        int dp[] = new int[length + 1];
        Arrays.fill(dp, -1);
        return solve(ribbons, length, dp);
    }

    public int solve(int ribbons[], int length, int dp[]) {
        if (length < 0) return INF;
        if (length == 0) return 0;
        if (dp[length] != -1) return dp[length];
        int ans = INF;
        for (int ribbon : ribbons) {
            ans = Math.max(ans, 1 + solve(ribbons, length - ribbon, dp));
        }
        return dp[length] = ans;
    }

}
