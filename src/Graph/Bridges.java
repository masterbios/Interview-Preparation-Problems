package Graph;

import java.util.Arrays;
import java.util.List;

public class Bridges {

    int par[], low[], disc[];
    int timer;
    boolean vis[];
    List<Integer> graph[];

    public void solve(List<Integer> g[], int vertices) {
        this.timer = 0;
        this.graph = g;
        par = new int[vertices];
        low = new int[vertices];
        disc = new int[vertices];
        vis = new boolean[vertices];
        Arrays.fill(par, -1);

        for (int i = 0; i < vertices; i++) {
            if (!vis[i]) dfs(i);
        }
    }

    public void dfs(int node) {
        timer++;
        vis[node] = true;
        low[node] = disc[node] = timer;
        for (int child : graph[node]) {
            if (!vis[child]) {
                par[child] = node;
                dfs(child);
                low[node] = Math.min(low[node], low[child]);
                if (low[child] > disc[node]) {
                    System.out.println(node + " " + child);
                }
            } else if (par[node] != child) {
                low[node] = Math.min(low[node], disc[child]);
            }
        }
    }

}
