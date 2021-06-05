package DynamicProgramming.Subsequence;

public class CountAllSubsequenceOfProductLessThanK {
    //Given a non negative array, find the number of subsequences having product smaller than K.
    int a[];
    int k;

    public CountAllSubsequenceOfProductLessThanK(int a[], int k) {
        this.a = a;
        this.k = k;
    }

    public int solve() {
        int n = a.length;
        int dp[][] = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (a[j - 1] <= i && a[j - 1] > 0) dp[i][j] += dp[i / a[j - 1]][j - 1] + 1;
            }
        }
        return dp[k][n];
    }
}
