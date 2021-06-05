package Graph;

public class FloydWarshall {
    /*
    all pair shortest path algo
    works for negative cycles also
    mat[i][j] = min(mat[i][j], mat[i][k] + mat[k][j];
    choose if we can choose an intermediate node to get shortest path

    graph[i][j] = INF if no path existe
    v => no of vertices from 0...v-1
     */

    final int INF = (1 << 29);

    public void solve(int graph[][], int n, int src) {
        int cost[][] = new int[n][n];
        for (int x[] : cost) java.util.Arrays.fill(x, INF);

        for (int x[] : graph) {
            int u = x[0], v = x[1], price = x[2];
            graph[u][v] = Math.min(graph[u][v], price);
        }

        cost[src][src] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][k] < INF && cost[k][j] < INF) {
                        cost[i][j] =  Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                    }
                }
            }
        }

    }
}
