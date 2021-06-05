package GoogleOnlineAssessment;

public class RelativeSort {
    public int minSwap(int[] a, int[] b) {
        int n = a.length;
        int swap[] = new int[n];
        int notswap[] = new int[n];
        swap[0] = 1;
        for (int i = 1; i < n; i++) {
            notswap[i] = swap[i] = n;
            if (a[i - 1] < a[i] && b[i - 1] < b[i]) {
                notswap[i] = notswap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (a[i - 1] < b[i] && b[i - 1] < a[i]) {
                notswap[i] = Math.min(notswap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], notswap[i - 1] + 1);
            }
        }
        return Math.min(swap[n - 1], notswap[n - 1]);
    }
}
