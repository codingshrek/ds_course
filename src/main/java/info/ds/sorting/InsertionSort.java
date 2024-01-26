package info.ds.sorting;

/**
 * Select an element(outer loop) , swap it with elements left to until a small no. is encountered.
 * Idea : array left to current elements is sorted and right is unsorted. Place the current element in the right pos. in sorted segment and shift the remaining to the right.
 */
public class InsertionSort {
    public static void insertionSort(int[] arr, int n) {
        for (int i = 0; i <= n - 1; i++) {
            int cur = i;
            while (cur > 0 && arr[cur] < arr[cur - 1]) {
                swap(arr, cur, cur - 1);
                cur--;
            }
        }


    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
