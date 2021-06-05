package GoogleOnlineAssessment;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; j++) {
            map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) map.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
