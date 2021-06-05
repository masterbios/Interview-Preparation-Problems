package DynamicProgramming.PalindromicSubsequence;

import java.util.HashMap;
import java.util.Map;

public class PalindromicPartitioning {

    Map<String, Integer> map = new HashMap<>();

    public int solve(char a[]) {
        int n = a.length;
        return solve(0, n - 1, a);
    }

    public int solve(int l, int r, char a[]) {
        if (l > r) return 0;
        String key = "" + l + "|" + r;
        if (map.containsKey(key)) return map.get(key);
        if (l == r) {
            map.put(key, 0);
            return 0;
        }
        if (isPalindrome(l, r, a)) {
            map.put(key, 0);
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = l; k < r; k++) {
            int leftmin = Integer.MAX_VALUE, rightmin = Integer.MAX_VALUE;
            String left = "" + l + "|" + k, right = "" + (k + 1) + "|" + r;
            if (map.containsKey(left)) leftmin = map.get(left);
            if (map.containsKey(right)) rightmin = map.get(right);
            if (leftmin == Integer.MAX_VALUE) leftmin = solve(l, k, a);
            if (rightmin == Integer.MAX_VALUE) rightmin = solve(k + 1, r, a);
            ans = Math.min(ans, 1 + leftmin + rightmin);
        }
        map.put(key, ans);
        return ans;
    }

    public boolean isPalindrome(int i, int j, char a[]) {
        while (i < j) {
            if (a[i] != a[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
