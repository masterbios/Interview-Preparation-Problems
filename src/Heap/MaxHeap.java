package Heap;

public class MaxHeap {

    int capacity;
    int size;
    int a[];

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        a = new int[capacity];
    }

    public void maxHeapify(int i) {
        int left = 2 * i + 1, right = 2 * i + 2, large = i;
        if (left < size && a[left] > a[large]) large = left;
        if (right < size && a[right] > a[large]) large = right;
        if (large != i) {
            swap(large, i);
            maxHeapify(large);
        }
    }

    public int extractMax() {
        if (size <= 0) return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return a[0];
        }
        int max = a[0];
        a[0] = a[--size];
        maxHeapify(0);
        return max;
    }

    public void decreaseKey(int i, int key) {
        if (i < 0 || i >= size) {
            System.out.println("can't change");
            return;
        }
        a[i] = key;
        while (i != 0 && a[parent(i)] < a[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void deleteKey(int i) {
        if (i < 0 || i >= size) {
            System.out.println("can't delete");
            return;
        }
        decreaseKey(i, Integer.MAX_VALUE);
        extractMax();
    }

    public boolean insertKey(int key) {
        if (size == capacity) {
            System.out.println("Full");
            return false;
        }
        a[size++] = key;
        int i = size - 1;
        while (i != 0 && a[parent(i)] < a[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
        return true;
    }

    public int parent(int idx) {
        return (idx - 1) / 2;
    }

    public void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}
