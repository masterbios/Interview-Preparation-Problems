package AmazonOnlineAssessment;

import java.util.ArrayList;
import java.util.List;

public class SubTreeWithMaxAverage {

    // this is just a tester function
    public void solve() {
        Node v1 = new Node(20);

        Node v2 = new Node(12);

        Node v3 = new Node(18);

        Node v4 = new Node(11);
        Node v5 = new Node(2);
        Node v6 = new Node(3);

        Node v7 = new Node(15);
        Node v8 = new Node(8);

        v3.child.add(v7);
        v3.child.add(v8);

        v2.child.add(v4);
        v2.child.add(v5);
        v2.child.add(v6);

        v1.child.add(v2);
        v1.child.add(v3);

        solve(v1);

    }

    Node ans;
    double max;
    // you should call this method from object
    public void solve(Node root) {
        ans = null;
        max = Double.MIN_VALUE;
        go(root);
        System.out.println((ans == null ? "null" : ans.val));
    }

    // [0] = sum, [1] = count;
    private double[] go(Node root) {
        if (root == null) return new double[]{0.0d, 0.0d};
        double count = 1.0d, sum = root.val;
        for (Node children : root.child) {
            double v[] = go(children);
            sum += v[0];
            count += v[1];
        }
        if (count > 1) {
            double avg = sum / count;
            if (Double.compare(max, avg) < 0) {
                max = avg;
                ans = root;
            }
        }
        return new double[]{sum, count};
    }

    class Node {
        int val;
        List<Node> child;
        public Node(int val) {
            this.val = val;
            this.child = new ArrayList<>();
        }
    }
}
