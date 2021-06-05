package DynamicProgramming.LongestCommonSubstring;

public class LongestCommonSubstring {
    char a[];
    char b[];

    public LongestCommonSubstring(String s1, String s2) {
        this.a = s1.toCharArray();
        this.b = s2.toCharArray();
    }

    public int solve() {
        int n = a.length, m = b.length;
        int dp[] = new int[m + 1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (a[i - 1] == b[j - 1]) {
                    dp[j] = 1 + prev;
                    ans = Math.max(ans, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return ans;
    }
}
