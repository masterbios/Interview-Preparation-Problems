package DynamicProgramming.KnapsackZeroOne;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    // use only + and - and count all possible sets for reaching sum X.

    Map<String, Integer> map = new HashMap<>();

    public int solve(int a[], int sum) {
        int n = a.length;
        return solve(n, a, sum, 0);
    }

    public int solve(int n, int a[], int sum, int cursum) {
        if (n < 0) return 0;
        if (n == 0) {
            if (sum == cursum) return 1;
            else return 0;
        }
        String key = "" + n + "|" + cursum;
        if (map.containsKey(key)) return map.get(key);
        int res = solve(n - 1, a, sum, cursum - a[n - 1]) +
                solve(n - 1, a, sum, cursum + a[n - 1]);
        map.put(key, res);
        return res;
    }
}
