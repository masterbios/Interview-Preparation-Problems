package GoogleOnlineAssessment;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        char a[] = S.toCharArray();
        int n = a.length;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(a[i])) continue;
            if (cnt > K) cnt = 1;
            sb.append(Character.toUpperCase(a[i]));
            if (cnt == K) sb.append('-');
            cnt++;
        }
        String ans = sb.reverse().toString();
        if (ans.length() != 0 && ans.charAt(0) == '-') return ans.substring(1);
        return ans;
    }
}
