package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllConnectedComponents {

    List<Integer> graph[];
    boolean visited[];
    Set<Integer> component;

    public void findAllConnectedComponents(int n, List<Integer> graph[]) {
        this.graph = graph;
        visited = new boolean[n];
        component = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                for (int node : component) {
                    System.out.print(node + " ");
                } System.out.println();
                component.clear();
            }
        }
    }

    public void dfs(int node) {
        visited[node] = true;
        component.add(node);
        for (int child : graph[node]) {
            if (!visited[node]) dfs(child);
        }
    }
}
