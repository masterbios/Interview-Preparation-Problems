package BinarySearchTree;

public class BST {

    public Node delete(Node root, int val) {
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null) { // 1 child
                return root.right;
            } else if (root.right == null) { // 1 child
                return root.left;
            } else { // 2 child then find inorder successor exist on right subtree minvalue
                Node min = findMin(root.right);
                root.val = min.val;
                root.right = delete(root.right, min.val);
            }
        }
        return root;
    }

    public Node kth(Node root, int k) {
        if (root == null) return root;
        Node left = kth(root.left, k);
        if (left != null) return left;
//        this.count++;
//        if (count == k) return root;
        return kth(root.right, k);
    }

    public Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public Node search(Node root, int val) {
        if (root == null) return root;
        if (root.val == val) return root;
        if (root.val < val) return search(root.right, val);
        return search(root.left, val);
    }

    class Node {
        int val;
        Node right, left;
        public Node(int val) {
            this.val = val;
        }
    }
}
