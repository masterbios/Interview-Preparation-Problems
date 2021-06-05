package AmazonOnlineAssessment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumUniquePairs {

    public void solve(int a[], int target) {
        int ans = go(a, target);
        System.out.println(ans);
    }

    private int go(int a[], int target) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        int ans = 0;

        for (int x : a) {
            int need = target - x;
            if (set.contains(need) && !seen.contains(x)) {
                ans++;
                seen.add(need);
                seen.add(x);
            }
            set.add(x);
        }

        return ans;
    }
}
