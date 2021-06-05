package DynamicProgramming.KnapsackZeroOne;

public class MinimumSubsetSumDifference {

    int memo[][];
    final int INF = 1 << 29;

    public int solveR(int a[]) {
        int sum = 0, n = a.length;
        for (int vals : a) sum += vals;
        memo = new int[n + 1][sum + 1];
        for (int x[] : memo) java.util.Arrays.fill(x, INF);
        solve(a, n, 0, sum);
//        for (int x[] : memo) {
//            for (int vals : x) System.out.print(vals + " ");
//            System.out.println();
//        }
        return memo[0][sum];
    }

    public int solve(int a[], int n, int curtotal, int sum) {
        if (n == 0) {
            memo[n][sum] = Math.min(memo[n][sum], Math.abs(sum - 2 * curtotal));
            return memo[n][sum];
        }
        if (memo[n][curtotal] != INF) return memo[n][curtotal];
        int pick = solve(a, n - 1, curtotal + a[n - 1], sum);
        int notpick = solve(a, n - 1, curtotal, sum);
        return memo[n][curtotal] = Math.min(pick, notpick);
    }


    public int solve(int a[]) {
        int sum = 0;
        for (int vals : a) sum += vals;
        int n = a.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) dp[j][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a[i - 1] <= j) {
                    dp[i][j] |= dp[i - 1][j - a[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}
