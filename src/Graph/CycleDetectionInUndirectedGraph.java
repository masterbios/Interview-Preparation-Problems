package Graph;

import java.util.List;
import java.util.Set;

/*
 Assuming graph can contains disconnected components
 */

public class CycleDetectionInUndirectedGraph {

    List<Integer> graph[];
    boolean visited[];


    /*
    @params graph : adjancey list of nodes;
    @params n : number of vertex from 0 to n - 1
     */

    public boolean isCyclic(int n, List<Integer> graph[]) {
        this.graph = graph;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isCyclic(i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    This function will return true if cycle exist, false otherwise
     */
    public boolean isCyclic(int node, int parent) {
        visited[node] = true;
        for (int child : graph[node]) {
            if (!visited[child]) {
                if (isCyclic(child, node)) return true;
            } else if (child != parent) {
                return true;
            }
        }
        return false;
    }
}
