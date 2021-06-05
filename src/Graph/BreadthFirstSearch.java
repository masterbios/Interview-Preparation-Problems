package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    List<Integer> graph[];
    boolean visited[];

    public void solve(int n, List<Integer> graph[]) {
        this.graph = graph;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) bfs(i);
        }
    }

    public void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size--> 0) {
                int vertex = q.poll();
                for (int child : graph[vertex]) {
                    if (!visited[child]) {
                        visited[child] = true;
                        q.offer(child);
                    }
                }
            }
        }
    }
}
