package DynamicProgramming.LongestCommonSubstring;

public class MaxLengthSubsequenceofXisSubstringofY {
    // Given two string X and Y. The task is to find the length of longest subsequence of string X which is substring in sequence Y.

    String x;
    String y;

    public MaxLengthSubsequenceofXisSubstringofY(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public int solve() {
        int n = x.length(), m = y.length();
        int dp[] = new int[m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (x.charAt(i - 1) == y.charAt(j - 1)) dp[j] = 1 + prev;
                prev = temp;
                ans = Math.max(ans, dp[j]);
            }
        }

        return ans;
    }
}
