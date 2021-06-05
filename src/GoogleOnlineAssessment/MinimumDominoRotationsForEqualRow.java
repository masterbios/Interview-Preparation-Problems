package GoogleOnlineAssessment;

public class MinimumDominoRotationsForEqualRow {

    int a[];
    int b[];

    public MinimumDominoRotationsForEqualRow(int a[], int b[]) {
        this.a = a;
        this.b = b;
    }

    public int solve() {
        int n = a.length;
        int counta[] = new int[7], countb[] = new int[7];
        int same[] = new int[7];
        for (int i = 0; i < n; i++) {
            counta[a[i]]++;
            countb[b[i]]++;
            if (a[i] == b[i]) same[a[i]]++;
        }
        for (int i = 1; i <= 6; i++) {
            if (counta[i] + countb[i] - same[i] == n) {
                return (n - Math.max(counta[i], countb[i]));
            }
        }
        return -1;
    }
}
