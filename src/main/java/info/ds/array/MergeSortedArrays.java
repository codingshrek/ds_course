package info.ds.array;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {


        int n = a.length;
        int m = b.length;

        int i = n - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            if (a[i] <= b[j]) break;
            if (a[i] > b[j]) {
                long temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);


    }
}
