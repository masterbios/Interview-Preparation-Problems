package DynamicProgramming.LongestCommonSubstring;

public class EditDistance {
    char a[];
    char b[];

    public EditDistance(String s1, String s2) {
        this.a = s1.toCharArray();
        this.b = s2.toCharArray();
    }

    public int solve() {
        int n = a.length, m = b.length;
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        return dp[n][m];
    }
}
