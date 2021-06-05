package DynamicProgramming.MatrixSum;

public class Matrix2dsum {
    int dp[][];
    public void sum(int a[][]) {
        int r = a.length, c = a[0].length;
        dp = new int[r + 1][c + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + a[i][j];
            }
        }
    }

    public int compute(int x1, int y1, int x2, int y2) {
        x2++; y2++;
        return (dp[x2][y2] - dp[x2][y1] - dp[x1][y2] + dp[x1][y1]);
    }
}
