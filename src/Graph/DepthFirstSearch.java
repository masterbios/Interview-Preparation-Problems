package Graph;

import java.util.List;

public class DepthFirstSearch {

    boolean visited[];
    List<Integer> graph[];

    public void solve(int n, List<Integer> graph[]) {
        this.graph = graph;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) dfs(i);
        }
    }

    public void dfs(int node) {
        visited[node] = true;
        for (int child : graph[node]) {
            if (!visited[child]) dfs(child);
        }
    }
}
