package GoogleOnlineAssessment;

public class MaxPathSum {

    boolean visited[][];
    int dir[][] = { {1, 1}, {1, 0}, {1, -1}};
    final long INF = Integer.MIN_VALUE;
    long ans = 0L;
    public long solve(int a[][]) {
        int r = a.length, c = a[0].length;
        visited = new boolean[r][c];
        int x1 = 0, y1 = 0, x2 = 0, y2 = c - 1;
        int d1 = r - 1, d2 = 0, d3 = r - 1, d4 = c - 1;
        dfs(a, x1, y1, r, c, 0L, d1, d2);
        dfs(a, x2, y2, r, c, ans, d3, d4);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) System.out.print(visited[i][j] + " ");
            System.out.println();
        }
        return ans;
    }

    public boolean dfs(int a[][], int curx, int cury, int r, int c, long ans1, int h1, int h2) {
        if (!isSafe(curx, cury, r, c)) return false;
        visited[curx][cury] = true;
        if (curx == h1 && cury == h2) {
            ans = Math.max(ans, ans1 + a[curx][cury]);
            return true;
        }
        for (int i = 0; i < 3; i++) {
            long cost = ans1 + a[curx][cury];
            dfs(a, curx + dir[i][0], cury + dir[i][1], r, c, cost, h1, h2);
        }
        visited[curx][cury] = false;
        return false;
    }

    public boolean isSafe(int x, int y, int r, int c) {
        if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y]) return false;
        return true;
    }
}
