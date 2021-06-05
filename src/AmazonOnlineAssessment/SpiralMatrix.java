package AmazonOnlineAssessment;

import java.util.Arrays;

public class SpiralMatrix {

    public void solve(int n) {
        int a[][] = go(n);
        for (int x[] : a) System.out.println(Arrays.toString(x));
    }

    private int[][] go(int n) {
        int a[][] = new int[n][n];
        int i = 0, j = 0, x = 1, m = n;
        while (i < n && j < m) {
            for (int col = i; col < m; col++) {
                a[i][col] = x++;
            }
            i++;
            for (int row = i; row < n; row++) {
                a[row][m - 1] = x++;
            }
            m--;
            if (j < m) {
                for (int col = m - 1; col >= j; col--) {
                    a[n - 1][col] = x++;
                }
                n--;
            }
            if (i < n) {
                for (int row = n - 1; row >= i; row--) {
                    a[row][j] = x++;
                }
                j++;
            }
        }

        return a;
    }
}
