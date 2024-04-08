package info.ds.binary_search;

public class RoseGarden {

    public static int roseGarden(int[] a, int r, int b) {
        int max = findMax(a);
        int low = 0;
        int high = max;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(a, mid, b, r)) {
                high = mid - 1;
                ans = mid;
            } else low = mid + 1;
        }

        return ans;

    }

    private static int findMax(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int p : a) {
            max = Math.max(max, p);
        }
        return max;
    }

    //b is the no. of bouquet and k is the number of adjacent roses in bouquet
    //h is the min days to check if bqs can be formed.
    private static Boolean isPossible(int[] a, int h, int b, int k) {

        int bc = 0; //No. of bq we created.
        int rc = 0; //No. of roses in each bq

        for (int d : a) {
            if (h >= d) rc++;
            else {
                //reset everything.
                rc = 0;
                continue;
            }
            //One bq formed.
            if (rc == k) {
                bc++;
                rc = 0;
            }
            if (bc == b) return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
