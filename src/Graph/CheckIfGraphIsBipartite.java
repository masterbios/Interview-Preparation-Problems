package Graph;

import java.util.List;

public class CheckIfGraphIsBipartite {

    // try to color graph with only two colors
    // if node is not color, color it with opposite color of the parent
    // if node is colored check if color[child] != color[par]
    int color[];
    List<Integer> graph[];

    public boolean isBipartite(List<Integer> graph[], int vertices) {
        this.graph = graph;
        color = new int[vertices + 1];
        for (int i = 0; i <= vertices; i++) color[i] = -1;
        for (int i = 0; i <= vertices; i++) {
            if (color[i] == -1) {
                color[i] = 1;
                if (!isBipartite(i)) return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int node) {
        for (int child : graph[node]) {
            if (color[child] == -1) {
                color[child] = color[node] == 1 ? 2 : 1;
                if (!isBipartite(child)) return false;
            } else if (color[child] == color[node]) {
                return false;
            }
        }
        return true;
    }
}
