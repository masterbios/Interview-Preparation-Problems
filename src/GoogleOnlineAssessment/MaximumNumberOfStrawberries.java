package GoogleOnlineAssessment;

import java.util.Arrays;

public class MaximumNumberOfStrawberries {
    int dp[][];

    public int solve(int n, int count[], int max) {
        dp = new int[n][max + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < n; i++) rec(i, count, max);
        return dp[n - 1][max];
    }

    public int rec(int idx, int a[], int weight) {
        if (idx < 0) return 0;
        if (dp[idx][weight] == -1) {
            int select = weight - a[idx] < 0 ? 0 : a[idx] + rec(idx - 2, a, weight - a[idx]);
            int notselect = idx - 1 < 0 ? 0 : rec(idx - 1, a, weight);
            dp[idx][weight] = Math.max(notselect, select);
        }
        return dp[idx][weight];
    }

}
