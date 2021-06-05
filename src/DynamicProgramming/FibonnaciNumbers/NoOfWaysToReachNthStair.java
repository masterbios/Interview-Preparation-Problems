package DynamicProgramming.FibonnaciNumbers;

public class NoOfWaysToReachNthStair {

    int stairs;
    int types;

    public NoOfWaysToReachNthStair(int stairs, int types) {
        this.stairs = stairs;
        this.types = types;
    }

    public int solve() {
        int dp[] = new int[stairs + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            for (int j = 1; j <= types && j <= i; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[stairs];
    }

    public int solve1() {
        if (stairs == 0 || stairs == 1) return 1;
        int ans = 0;
        int pprev = 1, prev = 1;
        for (int i = 2; i <= stairs; i++) {
            ans = pprev + prev;
            pprev = prev;
            prev = ans;
        }
        return ans;
    }
}
