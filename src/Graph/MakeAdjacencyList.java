package Graph;

import java.util.ArrayList;
import java.util.List;

public class MakeAdjacencyList {
    public List<Integer>[] makeGraph(int g[][], int vertex) {
        List<Integer> graph[] = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) graph[i] = new ArrayList<>();
        for (int x[] : g) {
            int u = x[0], v = x[1];
            graph[u].add(v); graph[v].add(u);
        }
        return graph;
    }
}
