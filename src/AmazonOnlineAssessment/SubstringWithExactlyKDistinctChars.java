package AmazonOnlineAssessment;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithExactlyKDistinctChars {

    public void solve(String s, int k) {
        int ans = go(s, k);
        System.out.println(ans);
    }

    private int go(String s, int k) {
        return atmost(s, k) - atmost(s, k - 1);
    }

    private int atmost(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char a[] = s.toCharArray();
        int n = a.length, l = 0, r = 0, count = 0;
        while (r < n) {
            map.put(a[r], map.getOrDefault(a[r], 0) + 1);
            r++;
            while (l < r && map.size() > k) {
                int c = map.get(a[l]);
                if (c == 1) map.remove(a[l]);
                else map.put(a[l], c - 1);
                l++;
            }
            count += r - l + 1;
        }

        return count;
    }
}
