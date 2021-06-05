package Sorting;

public class HeapSort {

    public static void sort(int a[]) {
        int n = a.length;
        buildHeap(a, n);
        for (int i = n - 1; i >= 1; i--) {
            int temp = a[0]; a[0] = a[i]; a[i] = temp;
            maxHeapify(a, i, 0);
        }
    }

    public static void buildHeap(int a[], int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            maxHeapify(a, n, i);
        }
    }

    public static void maxHeapify(int a[], int n, int i) {
        int left = 2 * i + 1, right = 2 * i + 2, large = i;
        if (left < n && a[large] < a[left]) large = left;
        if (right < n && a[large] < a[right]) large = right;
        if (large != i) {
            int temp = a[large]; a[large] = a[i]; a[i] = temp;
            maxHeapify(a, n, large);
        }
    }

}
