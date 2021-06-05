package GoogleOnlineAssessment;

import java.util.*;

public class Statistics {
    public void statistics(String fruits[], int prices[], int t) {
        Map<String, Pair> map = new HashMap<>();
        int n = fruits.length;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(fruits[i])) {
                Pair cur = new Pair();
                cur.max = Math.max(cur.max, prices[i]);
                cur.min = Math.min(cur.min, prices[i]);
                cur.size++;
                cur.sum += prices[i];
                map.put(fruits[i], cur);
            } else {
                Pair cur = map.get(fruits[i]);
                cur.max = Math.max(cur.max, prices[i]);
                cur.min = Math.min(cur.min, prices[i]);
                cur.size++;
                cur.sum += prices[i];
            }
        }
        Arrays.sort(fruits);
        System.out.println("Case #" + t + ":");
        Set<String> set = new HashSet<>();
        for (String fruit : fruits) {
            if (!set.add(fruit)) continue;
            Pair cur = map.get(fruit);
            long l = cur.min, h = cur.max, avg = (cur.sum / cur.size);
            System.out.println(fruit + " " + l + " " + h + " " + avg);
        }

    }

    class Pair {
        long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long sum = 0L;
        long size = 0L;
    }
}
