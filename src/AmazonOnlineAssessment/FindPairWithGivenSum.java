package AmazonOnlineAssessment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenSum {
    /*
    Given a list of positive integers nums and an int target,
    return indices of the two numbers such that they add up to a target - 30.

    Conditions:
    You will pick exactly 2 numbers.
    You cannot pick the same element twice.
    If you have muliple pairs, select the pair with the largest number.
     */

    public void solve(int a[], int target) {
        int cur[] = go(a, target);
        System.out.println(Arrays.toString(cur));
    }

    private int[] go(int a[], int target) {
        target -= 30;
        int n = a.length, ans[] = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int need = target - a[i];
            if (map.containsKey(need)) {
                int cur[] = {i, map.get(need)};
                Arrays.sort(ans);
                Arrays.sort(cur);
                if (cur[0] > ans[0] || cur[1] > ans[1]) {
                    ans = Arrays.copyOfRange(cur, 0, 2);
                }
            }
            map.put(a[i], i);
        }
        return ans;
    }
}
