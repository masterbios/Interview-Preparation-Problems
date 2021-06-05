package Graph;

public class BellmanFord {

    // single source shortest path algo
    // works also with the negative cycle
    // g[0] = u, g[1] = v, g[2] = wt

    final int INF = (1 << 29);

    public void solve(int g[][], int src, int vertices) {
        int dis[] = new int[vertices + 1];
        for (int i = 0; i <= vertices; i++) dis[i] = INF;
        dis[src] = 0;
        for (int i = 1; i < vertices; i++) { // vertex count
            for (int j = 0; j < g.length; j++) { // edges with weights
                int u = g[j][0], v = g[j][1], cost = g[j][2];
                if (dis[u] != INF && dis[u] + cost < dis[v]) {
                    dis[v] = dis[u] + cost;
                }
            }
        }

        for (int i = 0; i < g.length; i++) {
            int u = g[i][0], v = g[i][1], cost = g[i][2];
            if (dis[u] != INF && dis[u] + cost < dis[v]) {
                System.out.println("graph contains negative cycle");
                return;
            }
        }

        for (int i = 0; i < vertices; i++) {
            System.out.print(dis[i] + " ");
        } System.out.println();
    }
}
