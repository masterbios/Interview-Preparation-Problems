package DynamicProgramming.LongestCommonSubstring;

public class MaximumSumIncreasingSequence {

    int a[];

    public MaximumSumIncreasingSequence(int a[]) {
        this.a = a;
    }

    public long solve() {
        int n = a.length;
        int dp[] = new int[n];
        long ans = a[0];
        dp[0] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }
}
