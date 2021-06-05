package DynamicProgramming.LongestCommonSubstring;

public class LongestIncreasingSubsequence {

    int a[];

    public LongestIncreasingSubsequence(int a[]) {
        this.a = a;
    }

    public int solve2() {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ++ans;
    }

    public int solve1() {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 0;
        for (int find : a) {
            int idx = lower(dp, 0, ans, find);
            dp[idx] = find;
            if (idx == ans) ans++;
        }
        return ans;
    }

    public int lower(int a[], int low, int high, int val) {
        high--;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < val) low = mid + 1;
            else if (a[mid] == val) return mid;
            else high = mid - 1;
        }
        return low;
    }
}
