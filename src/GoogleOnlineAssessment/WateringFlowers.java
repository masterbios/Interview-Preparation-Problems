package GoogleOnlineAssessment;

public class WateringFlowers {
    int a[];
    int capacity1;
    int capacity2;

    public WateringFlowers(int a[], int capacity1, int capacity2) {
        this.a = a;
        this.capacity1 = capacity1;
        this.capacity2 = capacity2;
    }

    public int solve() {
        int refills = 0, x = 0, y = 0;
        int l = 0, r = a.length - 1;
        int n = a.length;
        while (l < r) {
            if (a[l] > x) {
                x = capacity1;
                refills++;
            }
            if (a[r] > y) {
                y = capacity2;
                refills++;
            }
            x -= a[l++];
            y -= a[r--];
        }
        if (n % 2 != 0) {
            if (x + y < a[l]) refills++;
        }
        return refills;
    }
}
