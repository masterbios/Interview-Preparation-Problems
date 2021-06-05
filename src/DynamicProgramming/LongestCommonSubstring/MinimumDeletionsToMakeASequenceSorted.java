package DynamicProgramming.LongestCommonSubstring;

public class MinimumDeletionsToMakeASequenceSorted {

    int a[];

    public MinimumDeletionsToMakeASequenceSorted(int a[]) {
        this.a = a;
    }

    public int solve() {
        int n = a.length, ans = 0;
        int dp[] = new int[n];

        for (int find : a) {
            int idx = lower(dp, 0, ans, find);
            dp[idx] = find;
            if (idx == ans) ans++;
        }

        return n - ans;
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
