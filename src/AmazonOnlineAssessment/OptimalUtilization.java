package AmazonOnlineAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalUtilization {

    // incomplete
    public void solve(int a[][], int b[][], int target) {
        List<int[]> list = go(a, b, target);
    }

    private List<int[]> go(int a[][], int b[][], int target) {
        int n = a.length, m = b.length;
        if (n > m) return go(b, a, target);
        // a < b
        Arrays.sort(a, (o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(b, (o1, o2) -> o1[1] - o2[1]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int need = target - a[i][1];
            int left = lowerbound(b, need);
            int right = upperbound(b, need);

        }
        return list;
    }

    private int lowerbound(int a[][], int find) {
        int n = a.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid][1] <= find) low = mid + 1;
            else high = mid - 1;
        }
        return low - 1;
    }

    private int upperbound(int a[][], int find) {
        int n = a.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid][1] < find) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

}
