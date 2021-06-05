package AmazonOnlineAssessment;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland2 {

    public void solve(char a[][]) {
        int ans = minCost(a);
        System.out.println(ans);
    }

    private int minCost(char a[][]) {
        if (a == null || a.length == 0) return 0;
        int n = a.length, m = a[0].length;
        int dir[][] = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        int ans = 1;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'S') {
                    queue.offer(new int[]{i, j});
                    a[i][j] = 'D';
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size--> 0) {
                int cur[] = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = dir[k][0] + cur[0], ny = dir[k][1] + cur[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || a[nx][ny] == 'D') continue;
                    if (a[nx][ny] == 'X') return ans;
                    queue.offer(new int[]{nx, ny});
                    a[nx][ny] = 'D';
                }
            }
            ans++;
        }

        return -1;
    }
}
