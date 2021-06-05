package SystemDesign;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }


    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur == null) {
            Node now = new Node(key, value);
            map.put(key, now);
            addToHead(now);
            size++;
            if (size > capacity) {
                size--;
                Node out = tail.prev;
                remove(out);
                map.remove(out.key);
            }
        } else {
            remove(cur);
            addToHead(cur);
            map.get(key).value = value;
        }
    }

    public int get(int key) {
        Node cur = map.get(key);
        if (cur == null) return -1;
        remove(cur);
        addToHead(cur);
        return cur.value;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + "=>");
            cur = cur.next;
        }
        System.out.println();
    }

    class Node {

        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = prev = null;
        }
    }

}
