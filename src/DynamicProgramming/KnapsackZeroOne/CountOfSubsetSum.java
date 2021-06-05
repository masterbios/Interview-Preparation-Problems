package DynamicProgramming.KnapsackZeroOne;

public class CountOfSubsetSum {
    final int INF = 1 << 29;

    public int solveI(int a[], int sum) {
        int n = a.length;
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - a[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - a[i - 1]];
                }
            }
        }
//        for (int x[] : dp) {
//            for (int vals : x) System.out.print(vals + " ");
//            System.out.println();
//        }
        return dp[n][sum];
    }

    int cache[][];

    public int solveR(int a[], int sum) {
        int n = a.length;
        cache = new int[n + 1][sum + 1];
        return solve(n, a, sum);
    }

    public int solve(int n, int a[], int sum) {
        if (n < 0 || sum < 0) return 0;
        if (n == 0) {
            if (sum == 0) return 1;
            else return 0;
        }
        if (cache[n][sum] != 0) return cache[n][sum];
        int res1 = solve(n - 1, a, sum - a[n - 1]);
        int res2 = solve(n - 1, a, sum);
        return cache[n][sum] = res1 + res2;
    }

}
