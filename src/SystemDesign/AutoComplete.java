package SystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoComplete {

    Node root;

    public AutoComplete(String dictionary[]) {
        root = new Node("");
        for (String word : dictionary) insertWord(word);
    }

    private void insertWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.child.containsKey(c)) {
                cur.child.put(c, new Node(word.substring(0, i + 1)));
            }
            cur = cur.child.get(c);
        }
        cur.isEnd = true;
    }

    public List<String> findWords(String prefix) {
        Node cur = root;
        List<String> list = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            if (!cur.child.containsKey(c)) return list;
            cur = cur.child.get(c);
        }
        findWords(cur, list);
        return list;
    }

    private void findWords(Node node, List<String> list) {
        if (node.isEnd) list.add(node.prefix);
        for (char c : node.child.keySet()) {
            findWords(node.child.get(c), list);
        }
    }

    private class Node {
        String prefix;
        Map<Character, Node> child;
        boolean isEnd;

        private Node(String prefix) {
            this.prefix = prefix;
            this.child = new HashMap<>();
            isEnd = false;
        }
    }

}

/*
String dictionary[] = {
                "appearance", "applicable","appreciate","apprentice","appendices","apparition", "applesaucez","appetizing",
                "achromatization", "acknowledgeably","acclimatization",
                "battleground", "backgrounder", "bantamweight","bacteriology","bachelorette","backbreaking","bacteriostat","baroreceptor",
                "bp","bmw","bmc","because"
        };
        String find[] = {
                "ap", "ac", "ba", "bm"
        };
        AutoComplete obj = new AutoComplete(dictionary);
        for (String search : find) {
            System.out.print("[" + search + "] ");
            for (String s : obj.findWords(search)) System.out.print(s + " ");
            System.out.println();
        }
* */




















