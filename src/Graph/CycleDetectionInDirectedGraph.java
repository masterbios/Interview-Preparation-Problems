package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleDetectionInDirectedGraph {
    List<Integer> graph[];
    Set<Integer> visited;
    Set<Integer> visiting;

    public boolean isCyclic(int n, List<Integer> graph[]) {
        this.graph = graph;
        visited = new HashSet<>();
        visiting = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (isCyclic(i)) return true;
        }

        return false;
    }

    public boolean isCyclic(int node) {
        if (visiting.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        visiting.add(node);

        for (int child : graph[node]) {
            if (isCyclic(child)) return true;
        }

        visiting.remove(node);
        return false;
    }
}
