package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public List<Integer> mergeKSortedArrays(int a[][]) {
        List<Integer> ans = new ArrayList<>();

        if (a == null) return ans;

        PriorityQueue<Triplet> queue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            queue.offer(new Triplet(a[i][0], i, 0));
        }

        while (!queue.isEmpty()) {
            Triplet cur = queue.poll();
            int value = cur.val, xpos = cur.row, ypos = cur.col + 1;
            ans.add(value);
            if (ypos < a[xpos].length) {
                queue.offer(new Triplet(a[xpos][ypos], xpos, ypos));
            }
        }

        return ans;
    }

    class Triplet implements Comparable<Triplet> {
        int val;
        int row;
        int col;

        public Triplet(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet that) {
            return this.val - that.val;
        }
    }
}
