package GoogleOnlineAssessment;

import java.util.HashMap;
import java.util.Map;

public class TimeToTypeAString {
    String text;
    String pattern;

    public TimeToTypeAString(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
    }

    public int solve() {
        int ans = 0, prev = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) map.put(text.charAt(i), i);
        for (char c : pattern.toCharArray()) {
            int idx = map.get(c);
            ans += Math.abs(idx - prev);
            prev = idx;
        }
        return ans;
    }
}
