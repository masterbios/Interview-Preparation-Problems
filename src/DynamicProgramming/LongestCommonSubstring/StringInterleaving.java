package DynamicProgramming.LongestCommonSubstring;

public class StringInterleaving {
    //Given three strings A, B and C. Write a function that checks whether C is an interleaving of A and B. C is said to be interleaving A and B, if it contains all characters of A and B and order of all characters in individual strings is preserved.

    char a[];
    char b[];
    char c[];

    public StringInterleaving(String s1, String s2, String s3) {
        this.a = s1.toCharArray();
        this.b = s2.toCharArray();
        this.c = s3.toCharArray();
    }

    public boolean solve() {
        int n = a.length, m = b.length, o = c.length;
        if (n + m != o) return false;

        boolean dp[][] = new boolean[n + 1][m + 1]; // n->a , m->b

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (b[j - 1] == c[j - 1]) dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    if (a[i - 1] == c[i - 1]) dp[i][j] = dp[i - 1][j];
                } else if (a[i - 1] == c[i + j - 1] && b[j - 1] != c[i + j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (a[i - 1] != c[i + j - 1] && b[j - 1] == c[i + j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else if (a[i - 1] == b[j - 1] && a[i - 1] == c[i + j - 1]) {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
