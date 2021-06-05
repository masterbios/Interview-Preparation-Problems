package AmazonOnlineAssessment;

import java.util.ArrayList;
import java.util.List;

public class ParititonLabel {
    // https://leetcode.com/problems/partition-labels/

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int cnt[] = new int[26];
        char a[] = S.toCharArray();
        int n = a.length;
        for (int i = 0; i < n; i++) cnt[a[i] - 'a'] = i;
        int j = 0, nxt = 0;
        for (int i = 0; i < n; i++) {
            j = Math.max(j, cnt[a[i] - 'a']);
            if (i == j) {
                list.add(i - nxt + 1);
                nxt = i + 1;
            }
        }
        return list;
    }
}
