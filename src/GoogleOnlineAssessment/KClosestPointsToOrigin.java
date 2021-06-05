package GoogleOnlineAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KClosestPointsToOrigin {
    int points[][];
    int k;

    public KClosestPointsToOrigin(int points[][], int k) {
        this.points = points;
        this.k = k;
    }

    public List<int[]> solve() {
        List<int[]> list = new ArrayList<>();
        int n = points.length;
        int dis[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            dis[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            dis[i][1] = i;
        }
        Arrays.sort(dis, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < k; i++) {
            list.add(new int[]{points[dis[i][1]][0], points[dis[i][1]][1]});
        }
        return list;
    }
}
