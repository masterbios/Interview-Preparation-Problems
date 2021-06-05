package DynamicProgramming.SubArray;

public class MaxContigousSumWithAtMostOneDeletion {
    public void solve(int a[]) {
        int n = a.length, maxsofar = a[0], curmax = a[0];
        int fw[] = new int[n];
        int bw[] = new int[n];

        fw[0] = a[0];
        for (int i = 1; i < n; i++) {
            curmax = Math.max(curmax + a[i], a[i]);
            maxsofar = Math.max(maxsofar, curmax);
            fw[i] = curmax;
        }

        int best = maxsofar;
        curmax = bw[n - 1] = a[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            curmax = Math.max(curmax + a[i], a[i]);
            bw[i] = curmax;
        }

        for (int i = 1; i + 1 < n; i++) {
            best = Math.max(best, fw[i - 1] + bw[i + 1]);
        }
        System.out.println(best);
    }
}
