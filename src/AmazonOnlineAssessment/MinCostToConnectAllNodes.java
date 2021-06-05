package AmazonOnlineAssessment;

import java.util.Arrays;

public class MinCostToConnectAllNodes {

    public void solve(int n, int edges[][], int newedges[][]) {
        System.out.println(connectAll(n, edges, newedges));
    }

    private int connectAll(int n, int edges[][], int newedges[][]) {
        DJSet set = new DJSet(n);
        int ans = 0;
        for (int x[] : edges) {
            int u = x[0] - 1, v = x[1] - 1;
            set.union(u, v);
        }
        Arrays.sort(newedges, (o1, o2) -> o1[2] - o2[2]);
//        for (int x[] : newedges) System.out.println(Arrays.toString(x));
        for (int x[] : newedges) {
            int u = x[0] - 1, v = x[1] - 1, cost = x[2];
            boolean formsCycle = set.find(u) == set.find(v);
            if (formsCycle) continue;
            set.union(u, v);
            ans += cost;
        }
        return ans;
    }

    class DJSet {

        int par[];
        int rank[];
        int n;

        public DJSet(int n) {
            this.n = n;
            par = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                par[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int node) {
            if (node == par[node]) return node;
            return par[node] = find(par[node]);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[b] > rank[a]) {
                    int temp = a; a = b; b = temp;
                }
                par[b] = a;
                rank[a] += rank[b];
            }
        }
    }
}
