package DynamicProgramming.FibonnaciNumbers;

import java.util.Arrays;

public class CuttingARodForMaxProfit {

    int n;
    int vals[];
    final int INF = (1 << 29);

    public CuttingARodForMaxProfit(int n, int vals[]) {
        this.n = n;
        this.vals = vals;
    }

    public int solve() {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + vals[j - 1]);
            }
        }
        return dp[n];
    }
}
