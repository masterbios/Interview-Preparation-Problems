package GoogleOnlineAssessment;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {
    TreeNode root;

    public MaximumLevelSumOfBinaryTree(TreeNode root) {
        this.root = root;
    }
    public int solve() {
        TreeNode root = this.root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0, sum = 0, level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            int cursum = 0;
            while (size--> 0) {
                TreeNode cur = q.poll();
                cursum += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            if (cursum > sum) {
                sum = cursum;
                ans = level;
            }
        }

        return ans;
    }
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.right = this.left = null;
        }
    }
}
