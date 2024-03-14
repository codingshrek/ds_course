package info.ds.sorting;

/**
 * Select the smallest element and swap with i in every iteration.
 * TC->O(n2) , SC->O(1)
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for(int i=0;i<len;i++){
            int min = i;
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;

        }
    }
}
