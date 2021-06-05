package DynamicProgramming.FibonnaciNumbers;

public class MinimumJumpsToReachEnd {

    int a[];
    final int INF = 1 << 29;

    public MinimumJumpsToReachEnd(int a[]) {
        this.a = a;
    }

    public int solve() { // O(N^2)
        if (a == null || a.length == 0 || a[0] == 0) return INF;
        int n = a.length;
        int dp[] = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = INF;
            for (int j = 0; j < i; j++) {
                if (a[j] + j >= i && dp[j] != INF) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public int solve1() { // O(N)
        if (a == null || a.length == 0 || a[0] == 0) return INF;
        int n = a.length;
        int maxreach = a[0], steps = a[0], jumps = 1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;
            maxreach = Math.max(maxreach, a[i] + i);
            steps--;
            if (steps == 0) {
                jumps++;
                if (maxreach <= i) return INF;
                steps = maxreach - i;
            }
        }
        return INF;
    }
}
