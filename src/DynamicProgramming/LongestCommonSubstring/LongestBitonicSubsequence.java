package DynamicProgramming.LongestCommonSubstring;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    int a[];

    public LongestBitonicSubsequence(int a[]) {
        this.a = a;
    }

    public int solve2() {
        int n = a.length;
        int ans = 0;
        int dp[] = new int[n];
        int LIS[] = new int[n];
        int LDS[] = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = lower(dp, 0, ans, a[i]);
            dp[idx] = a[i];
            if (idx == ans) ans++;
            LIS[i] = ans;
        }
        ans = 0;
        Arrays.fill(dp, 0);
        for (int i = n - 1; i >= 0; i--) {
            int idx = lower(dp, 0, ans, a[i]);
            dp[idx] = a[i];
            if (idx == ans) ans++;
            LDS[i] = ans;
        }
        ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, LIS[i] + LDS[i] - 1);
        return ans;
    }

    public int lower(int a[], int low, int high, int key) {
        high--;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < key) low = mid + 1;
            else if (a[mid] == key) return mid;
            else high = mid - 1;
        }
        return low;
    }

    public int solve1() {
        int n = a.length;
        int LIS[] = new int[n];
        int LDS[] = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] < a[i]) LDS[i] = Math.max(LDS[i], LDS[j] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, LIS[i] + LDS[i] + 1);
        return ans;
    }
}
