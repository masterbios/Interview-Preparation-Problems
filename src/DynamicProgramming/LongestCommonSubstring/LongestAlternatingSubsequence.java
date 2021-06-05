package DynamicProgramming.LongestCommonSubstring;

public class LongestAlternatingSubsequence {
    int a[];

    public LongestAlternatingSubsequence(int a[]) {
        this.a = a;
    }

    public int solve() {
        int n = a.length, ans = 0;
        int dp[][] = new int[2][n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[0][i] = Math.max(dp[0][i], dp[1][j] + 1);
                }
                if (a[j] > a[i]) {
                    dp[1][i] = Math.max(dp[1][i], dp[0][j] + 1);
                }
            }
            ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
        }
        return ++ans;
    }
}
