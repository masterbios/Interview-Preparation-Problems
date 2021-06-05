package DynamicProgramming.LongestCommonSubstring;

public class MinimumDeletionsAndInsertionsToTransformAStringToAnotherString {

    String s1;
    String s2;

    public MinimumDeletionsAndInsertionsToTransformAStringToAnotherString(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void solve() {
        int n = s1.length(), m = s2.length();
        int dp[] = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        System.out.println("Minimum deletions = " + (n - dp[m]));
        System.out.println("Minimum insertions = " + (m - dp[m]));
    }
}
