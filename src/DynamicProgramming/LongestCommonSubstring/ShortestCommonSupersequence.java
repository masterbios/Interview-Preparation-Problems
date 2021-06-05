package DynamicProgramming.LongestCommonSubstring;

public class ShortestCommonSupersequence {

    String s1;
    String s2;

    public ShortestCommonSupersequence(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public int solve() {
        int n = s1.length(), m = s2.length(), ans = 0;
        int dp[] = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = 1 + prev;
                    ans = Math.max(ans, dp[j]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        ans = n + m - ans;

        return ans;
    }
}
