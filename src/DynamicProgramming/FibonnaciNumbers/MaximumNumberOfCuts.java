package DynamicProgramming.FibonnaciNumbers;

import java.util.Arrays;

public class MaximumNumberOfCuts {

    final int INF = (1 << 29);

    int n;
    int vals[];

    public MaximumNumberOfCuts(int n, int vals[]) {
        this.n = n;
        this.vals = vals;
    }

    public int solve() {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -INF);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int size : vals) {
                if (i - size >= 0 && dp[i - size] != -INF) {
                    dp[i] = Math.max(dp[i], dp[i - size] + 1);
                }
            }
        }
        return (dp[n] == -INF ? -INF : dp[n]);
    }

}
