package DynamicProgramming.SubArray;

public class MaximumContigiousSum {

    public int solve(int a[]) {
        int n = a.length;
        int maxsofar = a[0], curmax = a[0];
        for (int i = 1; i < n; i++) {
            curmax = Math.max(curmax, a[i] + curmax);
            maxsofar = Math.max(maxsofar, curmax);
        }
        return maxsofar;
    }
}
