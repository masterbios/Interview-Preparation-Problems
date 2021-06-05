package DynamicProgramming.PalindromicSubsequence;

public class LongestPalindromicSubstring {

    public int solve(char a[]) {
        int n = a.length;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len1 = check(i, i, a);
            int len2 = check(i, i + 1, a);
            int max = Math.max(len1, len2);
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + (max / 2);
            }
        }
        return end - start + 1;
    }

    public int check(int l, int r, char a[]) {
        while (l >= 0 && r < a.length && a[l--] == a[r++]);
        return r - l - 1;
    }

}
