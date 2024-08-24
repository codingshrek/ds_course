package info.ds.binary_search;

import java.util.ArrayList;

public class KthElementIn2SortedArray {
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n1, int n2, int k) {

        if (n1 > n2) kthElement(b, a, n2, n1, k);
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);
        int left = k;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            int l1 = mid1 > 0 ? a.get(mid1 - 1) : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b.get(mid2 - 1) : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a.get(mid1) : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b.get(mid2) : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;

        }
        return 0;
    }
}
