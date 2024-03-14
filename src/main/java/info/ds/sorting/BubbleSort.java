package info.ds.sorting;

/**
 * Bubble the largest element in the last.
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr, int n) {

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[i]) swap(arr, i, j);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
