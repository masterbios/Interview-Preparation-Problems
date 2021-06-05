package AmazonOnlineAssessment;

public class NumberOfDiceRollsWithTargetSum {
    final long mod = (long) (1e9) + 7L;

    public void solve(int dice, int faces, int target) {
        int ans1 = itertive(dice, faces, target);
        int ans2 = 9; //recursive(dice,faces, target);
        System.out.println(ans1 + " " + ans2);
    }

    private int itertive(int dice, int faces, int target) {
        long dp[][] = new long[target + 1][dice + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= dice; j++) {
                for (int k = 1; k <= faces; k++) {
                    if (i >= k) {
                        dp[i][j] += dp[i - k][j - 1];
                        if (dp[i][j] >= mod) dp[i][j] -= mod;
                    }
                }
            }
        }
        return (int)dp[target][dice];
    }

//    public int recursive(int dice, int faces, int target) {
//        if (target == 0 && )
//    }
}
