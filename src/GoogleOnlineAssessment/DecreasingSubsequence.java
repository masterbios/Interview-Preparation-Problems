package GoogleOnlineAssessment;

public class DecreasingSubsequence {
    int a[];

    public DecreasingSubsequence(int a[]) {
        this.a = a;
    }

    public int solve() {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 0;
        for (int find : a) {
            int idx = lower(dp, 0, ans - 1, find);
            dp[idx] = find;
            if (idx == ans) ans++;
        }
        return ans;
    }

    public int lower(int vals[], int l, int r, int find) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (vals[mid] < find) l = mid + 1;
            else if (vals[mid] == find) return mid;
            else r = mid - 1;
        }
        return l;
    }
}
