package DynamicProgramming.PalindromicSubsequence;

public class PalindromicSubsequence {

    int dp[][];

    public int solve(char a[]) {
        int n = a.length;
        dp = new int[n][n];
        for (int x[] : dp) java.util.Arrays.fill(x, -1);
        return solve(0, n - 1, a);
    }

    public int solve(int l, int r, char a[]) {
        if (l > r) return 0;
        if (l == r) return 1;
        if (a[l] == a[r] && l + 1 == r) return 2;
        if (dp[l][r] != -1) return dp[l][r];
        if (a[l] == a[r]) return solve(l + 1, r - 1, a) + 2;
        int res = Math.max(solve(l + 1, r, a), solve(l, r - 1, a));
        return dp[l][r] = res;
    }

    public int solveI(char a[]) {
        int n = a.length;
        int memo[][] = new int[n][n];
        for (int i = 0; i < n; i++) memo[i][i] = 1;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] == a[i + 1]) memo[i][i + 1] = 2;
            else memo[i][i + 1] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int l = 0; l + i < n; l++) {
                int r = l + i;
                if (a[l] == a[r]) memo[l][r] = 2 + memo[l + 1][r - 1];
                else memo[l][r] = Math.max(memo[l + 1][r], memo[l][r - 1]);
            }
        }
        return memo[0][n - 1];
    }
}
