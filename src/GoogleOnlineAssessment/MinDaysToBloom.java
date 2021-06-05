package GoogleOnlineAssessment;

public class MinDaysToBloom {
    public int minDays(int roses[], int k, int n) {
        if (roses == null || k == 0 || n == 0) return 0;
        if (n * k > roses.length) return -1;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int vals : roses) {
            l = Math.min(l, vals);
            r = Math.max(r, vals);
        }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(roses, mid, k, n)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean isValid(int roses[], int day, int size, int count) {
        int cursize = 0, curcount = 0;
        for (int val : roses) {
            if (val <= day) cursize++;
            else cursize = 0;
            if (cursize == size) { cursize = 0; curcount++; }
            if (curcount == count) return true;
        }
        return false;
    }
}
