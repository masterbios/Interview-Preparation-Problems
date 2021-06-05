package GoogleOnlineAssessment;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinNumberOfChairs {

    int s[];
    int e[];

    public MinNumberOfChairs(int s[],int e[]) {
        this.s = s;
        this.e = e;
    }

    public int solve() {
        int n = s.length;
        Pair a[] = new Pair[n];
        for (int i = 0; i < n; i++) a[i] = new Pair(s[i], e[i]);
        Arrays.sort(a, (o1, o2) -> {
            if (o1.start != o2.start) return o1.start - o2.start;
            else return o1.end - o2.end;
        });
        PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.end != o2.end) return o1.end - o2.end;
            return o1.start - o2.start;
        });
        q.offer(a[0]);
        for (int i = 1; i < n; i++) {
            Pair cur = a[i];
            Pair prev = q.poll();
            if (prev.end <= cur.start) {
                prev.end = cur.end;
            } else {
                q.offer(cur);
            }
            q.offer(prev);
        }
        return q.size();
    }

    class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
