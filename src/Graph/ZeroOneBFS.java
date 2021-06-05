package Graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZeroOneBFS {

    // https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

    final int INF = (1 << 29);

    public void solve(List<Pair> graph[], int n, int src) {
        int dis[] = new int[n];
        Deque<Integer> q = new LinkedList<>();

        Arrays.fill(dis, INF);
        q.offerFirst(src);
        dis[src] = 0;

        while (!q.isEmpty()) {
            int node = q.pollFirst();
            for (Pair adj : graph[node]) {
                int child = adj.to, cost = adj.cost;
                if (dis[child] > dis[node] + cost) {
                    dis[child] = dis[node] + cost;
                    if (cost == 1) q.offerLast(child);
                    else q.offerFirst(child);
                }
            }
        }

    }

    class Pair {
        int to, cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
