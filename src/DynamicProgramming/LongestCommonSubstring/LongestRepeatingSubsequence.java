package DynamicProgramming.LongestCommonSubstring;

public class LongestRepeatingSubsequence {

    String s;

    public LongestRepeatingSubsequence(String s) {
        this.s = s;
    }

    public int solve() {
        int n = s.length(), ans = 0;
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) dp[j] = 1 + prev;
                else dp[j] = Math.max(dp[j - 1], dp[j]);
                prev = temp;
                ans = Math.max(ans, dp[j]);
            }
        }
        return ans;
    }
}
