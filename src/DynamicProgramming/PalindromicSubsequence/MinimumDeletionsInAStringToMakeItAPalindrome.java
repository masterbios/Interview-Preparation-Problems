package DynamicProgramming.PalindromicSubsequence;

public class MinimumDeletionsInAStringToMakeItAPalindrome {

    public int solve(char a[]) {
        // n - length of longest palindromic subsequence
        int n = a.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] == a[i + 1]) dp[i][i + 1] = 2;
            else dp[i][i + 1] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int l = 0; l + i < n; l++) {
                int r = l + i;
                if (a[l] == a[r]) dp[l][r] = 2 + dp[l + 1][r - 1];
                else dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
            }
        }
        return n - dp[0][n - 1];
    }

}
