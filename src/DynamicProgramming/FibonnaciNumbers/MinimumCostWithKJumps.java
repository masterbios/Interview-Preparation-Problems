package DynamicProgramming.FibonnaciNumbers;

import java.util.Arrays;

public class MinimumCostWithKJumps {

    final int INF = 1 << 29;
    int a[];
    int k;

    public MinimumCostWithKJumps(int a[], int k) {
        this.a = a;
        this.k = k;
    }

    public int solve2() { // Based on bellman-Ford node relaxation
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                dp[j] = Math.min(dp[j], Math.abs(a[i] - a[j]) + dp[i]);
            }
        }
        return dp[n - 1];
    }

    public int solve1() { // recursion based
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, INF);
        return solve1(0, n, dp);
    }

    public int solve1(int i, int n, int dp[]) {
        if (i == n - 1) return 0;
        if (dp[i] != INF) return dp[i];
        int cost = INF;
        for (int j = i + 1; j <= i + k && j < n; j++) {
            cost = Math.min(cost, Math.abs(a[i] - a[j]) + solve1(j, n, dp));
        }
        return dp[i] = cost;
    }

}
