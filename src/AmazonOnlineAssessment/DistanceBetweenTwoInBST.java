package AmazonOnlineAssessment;

public class DistanceBetweenTwoInBST {

    public void solve(Node root, int v1, int v2) {
        int ans = 0;
        if (v1 < v2) ans = dfs(root, v1, v2);
        else ans = dfs(root, v2, v1);
        System.out.println(ans);
    }

    private int dfs(Node root, int v1, int v2) {
        if (root == null) return 0;
        if (root.val < v1 && root.val < v2) return dfs(root.right, v1, v2);
        else if (root.val > v1 && root.val > v2) return dfs(root.left, v1, v2);
        else if (root.val >= v1 && root.val <= v2) return dfs2(root, v1) + dfs2(root, v2);
        return 0;
    }

    private int dfs2(Node root, int x) {
        if (root == null) return 0;
        else if (root.val > x) return 1 + dfs2(root.left, x);
        else return 1 + dfs2(root.right, x);
    }

    class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
}
