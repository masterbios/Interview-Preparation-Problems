package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class MinAndMaxInAWindowOfSizeK {
    public boolean solve(int k, int a[], int dis) {
        int n = a.length;
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!max.isEmpty() && a[max.peekLast()] <= a[i]) max.pollLast();
            while (!min.isEmpty() && a[min.peekLast()] >= a[i]) min.pollLast();
            max.addLast(i);
            min.addLast(i);
        }
        for (int i = k; i < n; i++) {
            if (a[max.peek()] - a[min.peek()] <= dis) return true;
            while (!max.isEmpty() && max.peek() <= i - k) max.pollFirst();
            while (!max.isEmpty() && a[max.peekLast()] <= a[i]) max.pollLast();
            while (!min.isEmpty() && min.peek() <= i - k) min.pollFirst();
            while (!min.isEmpty() && a[min.peekLast()] >= a[i]) min.pollLast();
            max.offerLast(i);
            min.offerLast(i);
        }
        if (a[max.peek()] - a[min.peek()] <= dis) return true;
        return false;
    }

}
