package DynamicProgramming.EggDrop;

import java.util.Arrays;

public class EggDropping {

    int dp[][];

    public int solve(int egg, int floor) {
        dp = new int[egg + 1][floor + 1];
        for (int x[] : dp) Arrays.fill(x, -1);
        return go1(egg, floor);
    }

    // time : O(K * NlogN)
    // space : O(K * N)
    private int go1(int egg, int floor) {
        if (floor <= 1) return floor;
        if (egg == 1) return floor;
        if (dp[egg][floor] != -1) return dp[egg][floor];
        int ans = (1 << 29), low = 1, high = floor;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int a = go2(egg - 1, mid - 1);
            int b = go2(egg, floor - mid);
            ans = Math.min(ans, 1 + Math.max(a, b));
            if (a == b) break;
            else if (a < b) low = mid + 1;
            else high = mid - 1;
        }
        return dp[egg][floor] = ans;
    }

    // time : O(egg * log(floor))
    // space : O(1)

    private int go2(int egg, int floor) {
        int low = 1, high = floor;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (binomialCoefficientSum(mid, egg, floor) < floor) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int binomialCoefficientSum(int x, int n, int k) {
        int sum = 0, term = 1;
        for (int i = 1; i <= n && sum < k; i++) {
            term *= x - i + 1;
            term /= i;
            sum += term;
        }
        return sum;
    }

}
