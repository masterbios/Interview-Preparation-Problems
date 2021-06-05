package GoogleOnlineAssessment;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {
    public int oddEvenJumps(int[] a) {
        int n = a.length, res = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean higher[] = new boolean[n];
        boolean lower[] = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        map.put(a[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            Map.Entry hi = map.ceilingEntry(a[i]), lo = map.floorEntry(a[i]);
            if (hi != null) higher[i] = lower[(int)hi.getValue()];
            if (lo != null) lower[i] = higher[(int)lo.getValue()];
            if (higher[i]) res++;
            map.put(a[i], i);
        }

        return res;
    }
}
