package GoogleOnlineAssessment;

import java.util.*;

public class DelayedProjects {

    List<Character> list = new ArrayList<>();
    Map<Character, List<Character>> map = new HashMap<>();
    Set<Character> failed = new HashSet<>();
    Set<Character> visited = new HashSet<>();

    public void delayedProjects(char edges[][], char fail[], int t) {
        list.clear(); map.clear(); failed.clear(); visited.clear();
        for (char edge[] : edges) {
            if (!map.containsKey(edge[1])) map.put(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        for (char x : fail) failed.add(x);
        for (char node : failed) if (!visited.contains(node)) topologicalSort(node);
        Collections.sort(list);
        System.out.print("Case #" + t + ": ");
        for (char x : list) System.out.print(x + " ");
        System.out.println();
    }

    public void topologicalSort(char node) {
        if (!visited.add(node)) return;
        if (map.get(node) != null) {
            for (char child : map.get(node)) {
                topologicalSort(child);
            }
        }
        list.add(node);
    }
}
