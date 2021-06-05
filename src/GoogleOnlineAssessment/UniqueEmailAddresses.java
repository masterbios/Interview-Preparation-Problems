package GoogleOnlineAssessment;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for (String word : emails) {
            String s[] = word.split("@");
            String cur = "";
            for (char c : s[0].toCharArray()) {
                if (c == '.') continue;
                else if (c == '+') break;
                cur += c;
            }
            cur += "@" + s[1];
            set.add(cur);
        }
        return set.size();
    }
}
