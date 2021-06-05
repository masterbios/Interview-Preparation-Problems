package GoogleOnlineAssessment;

import java.util.TreeSet;

public class StoresAndHouses {
    public int[] storesAndHouses(int houses[], int stores[]) {
        int n = houses.length;
        int res[] = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        for (int store : stores) set.add(store);
        for (int i = 0; i < n; i++) {
            Integer hi = set.ceiling(houses[i]), lo = set.floor(houses[i]);
            if (hi == null || lo == null) res[i] = hi == null ? lo : hi;
            else res[i] = (houses[i] - lo <= hi - houses[i]) ? lo : hi;
        }
        return res;
    }
}
