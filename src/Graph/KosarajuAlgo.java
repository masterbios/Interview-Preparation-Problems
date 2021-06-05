package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {

    List<Integer> graph[];
    Stack<Integer> st;
    boolean vis[];
    int vertices;
    int components;

    public int solve(List<Integer> g[], int vertices) {
        this.components = 0;
        this.graph = g;
        this.vertices = vertices;
        this.st = new Stack<>();
        this.vis = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!vis[i]) dfs(i, true);
        }

        Arrays.fill(vis, false);

        this.graph = reverse(g);
        System.out.println(st);
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node]) continue;
            System.out.println("start=" + node);
            dfs(node, false);
            System.out.println();
            components++;
        }

        return components;
    }


    public void dfs(int node, boolean fillstack) {
        vis[node] = true;
        if (!fillstack) System.out.print((node + 1) + " ");
        for (int child : graph[node]) {
            if (vis[child]) continue;
            dfs(child, fillstack);
        }
        if (fillstack) st.push(node);
    }

    public List<Integer>[] reverse(List<Integer> g[]) {
        List<Integer> rev[] = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) rev[i] = new ArrayList<>();
        for (int v = 0; v < g.length; v++) {
            for (int u : g[v]) rev[u].add(v);
        }
        return rev;
    }

}
