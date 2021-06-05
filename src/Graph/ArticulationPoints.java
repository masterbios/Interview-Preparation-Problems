package Graph;

import java.util.Arrays;
import java.util.List;

public class ArticulationPoints {
    int par[], low[], disc[];
    int timer;
    boolean vis[], AP[];
    List<Integer> graph[];

    public void solve(List<Integer> g[], int vertices) {
        this.timer = 0;
        this.graph = g;
        par = new int[vertices];
        low = new int[vertices];
        disc = new int[vertices];
        AP = new boolean[vertices];
        vis = new boolean[vertices];
        Arrays.fill(par, -1);
        for (int i = 0; i < vertices; i++) {
            if (!vis[i]) dfs(i);
        }
        for (int i = 0; i < vertices; i++) {
            if (AP[i]) System.out.println(i + " is articulation point");
        }
    }

    public void dfs(int node) {
        timer++;
        vis[node] = true;
        low[node] = disc[node] = timer;
        int children = 0;
        for (int child : graph[node]) {
            if (!vis[child]) {
                children++;
                par[child] = node;
                dfs(child);
                low[node] = Math.min(low[node], low[child]);
                if (par[node] == -1 && children > 1) {
                    AP[node] = true;
                }
                if (par[node] != -1 && low[child] >= disc[node]) {
                    AP[node] = true;
                }
            } else if (par[node] != child) {
                low[node] = Math.min(low[node], disc[child]);
            }
        }
    }
}
