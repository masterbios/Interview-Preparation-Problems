package AmazonOnlineAssessment;

public class CopyListWithRandomPointer {

    public void solve(Node head) {
        Node clone = deepCopy(head);
    }

    private Node deepCopy(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
        }
        cur = head;
        Node clone = cur.next, ans = cur.next;

        while (cur != null && clone != null) {
            if (cur.next != null) cur.next = cur.next.next;
            if (clone.next != null) clone.next = clone.next.next;
            cur = cur.next;
            clone = clone.next;
        }

        return ans;
    }

    class Node {
        int val;
        Node next, random;
        public Node(int val) {
            this.val = val;
        }
    }
}
