package AmazonOnlineAssessment;


public class MaxOfMinAltitudes {

    public void solve(int a[][]) {
        int ans = go(a);
        System.out.println(ans);
    }

    private int go(int a[][]) {
        int n = a.length, m = a[0].length;
        a[0][0] = a[n - 1][m - 1] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    a[i][j] = Math.min(a[i][j], a[i][j - 1]);
                } else if (j == 0) {
                    a[i][j] = Math.min(a[i][j], a[i - 1][j]);
                } else {
                    a[i][j] = Math.max(Math.min(a[i - 1][j], a[i][j]),
                                        Math.min(a[i][j], a[i][j - 1]));
                }
            }
        }
        return a[n - 1][m - 1];
    }
}
