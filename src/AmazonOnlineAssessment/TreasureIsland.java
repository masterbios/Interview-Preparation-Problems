package AmazonOnlineAssessment;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {

    public void solve(char a[][]) {
        int ans = minSteps(a);
        System.out.println(ans);
    }

    private int minSteps(char a[][]) {
        int dir[][] = {
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };
        if (a == null || a.length == 0) return 0;

        int n = a.length, m = a[0].length, steps = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        a[0][0] = 'D';

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--> 0) {
                int cur[] = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cur[0] + dir[k][0], ny = cur[1] + dir[k][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || a[nx][ny] == 'D') continue;
                    if (a[nx][ny] == 'X') return steps + 1;
                    queue.offer(new int[]{nx, ny});
                    a[nx][ny] = 'D';
                }
            }
            steps++;
        }

        return -1;
    }
}
