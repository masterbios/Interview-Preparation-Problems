package DynamicProgramming.PalindromicSubsequence;

public class CountOfPalindromicSubstrings {

//    public int solveR(String s) { /*==Wrong Solution==*/
//        boolean dp[][] = new boolean[s.length()][s.length()];
//        return solveR(s.toCharArray(), 0, s.length() - 1, dp);
//    }
//
//    public int solveR(char a[], int l, int r, boolean dp[][]) {
//        if (l > r) return 0;
//        if (l == r) { dp[l][r] = true; return 1; }
//        if (l + 1 == r) {
//            if (a[l] == a[r]) { dp[l][r] = true; return 2; }
//            else { return 0;}
//        }
//        if (dp[l][r]) return 1;
//        int ans = 0;
//        if (a[l] == a[r]) {
//            int add = solveR(a, l + 1, r - 1, dp);
//            if (add == 1) { dp[l][r] = true; return 1; }
//        } else {
//            int o1 = solveR(a, l + 1, r, dp);
//            int o2 = solveR(a, l, r - 1, dp);
//            if (o1 > 0) { dp[l + 1][r] = true; ans += o1; }
//            if (o2 > 0) { dp[l][r - 1] = true; ans += o2; }
//        }
//        return ans;
//    }

    public int solveI(String s) {
        char a[] = s.toCharArray();
        int ans = 0, n = a.length;
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == a[i + 1]) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int l = 0; l + i < n; l++) {
                int r = l + i;
                if (a[l] == a[r] && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
