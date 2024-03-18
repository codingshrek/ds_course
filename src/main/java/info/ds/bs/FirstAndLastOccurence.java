package info.ds.bs;

import java.util.ArrayList;

public class FirstAndLastOccurence {

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int n, int x) {

        int low = 0;
        int high = n - 1;

        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    public static int[] firstAndLastPosition(ArrayList<Integer> list, int n, int k) {

        int arr[] = list.stream().mapToInt(i -> i).toArray();
        int lb = lowerBound(arr, n, k);
        if (arr[lb] != k) return new int[]{-1, -1};
        int ub = upperBound(arr, n, k);
        return new int[]{lb, ub - 1};
    }
}
