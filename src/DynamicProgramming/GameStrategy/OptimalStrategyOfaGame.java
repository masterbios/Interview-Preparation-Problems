package DynamicProgramming.GameStrategy;

public class OptimalStrategyOfaGame {

    long dp[][];

    public long countMaximum(int arr[], int n) {
        dp = new long[n + 1][n + 1];
        for (long x[] : dp) java.util.Arrays.fill(x, -1L);
        return solve(0, n - 1, arr);
    }

    public long solve(int left, int right, int a[]) {
        if (left + 1 == right) return Math.max(a[left], a[right]);
        if (dp[left][right] != -1) return dp[left][right];
        long res = Math.max(a[left] + Math.min(solve(left + 2, right, a),
                                               solve(left + 1, right - 1, a)),
                            a[right] + Math.min(solve(left, right - 2, a),
                                                solve(left + 1, right - 1, a))
        );
        return dp[left][right] = res;
    }

    public long solveI(int a[], int n) {
        long dp[][] = new long[n][n];

        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = Math.max(a[i], a[i + 1]);
        }
        for (int len = 3; len < n; len += 2) {
            for (int l = 0; l < n; l++) {
                int r = l + len;
                dp[l][r] = Math.max(a[l] + Math.min(dp[l + 1][r - 1], dp[l + 2][r]),
                                    a[r] + Math.min(dp[l + 1][r - 1], dp[l][r - 2]));
            }
        }

        return dp[0][n - 1];
    }
}
