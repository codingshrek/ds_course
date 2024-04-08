package info.ds.binary_search;

public class CapacityToShipPackages {

    public static int leastWeightCapacity(int[] weights, int d) {
        int tSum = 0;
        int max = Integer.MIN_VALUE;
        for (int w : weights) {
            max = Math.max(max, w);
            tSum += w;
        }

        //Our range lies b/w max - totalSum.
        int low = max;
        int high = tSum;
        int ans = tSum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(weights, mid, d)) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;

    }

    private static Boolean isPossible(int weights[], int maxC, int d) {
        int dW = 0; //Daily weight
        for (int w : weights) {
            if ((dW + w) > maxC) {
                d--;
                if (d <= 0) return Boolean.FALSE;
                dW = w;
                continue;
            }
            //if(d<=0) return Boolean.FALSE;
            dW += w;
        }
        return Boolean.TRUE;
    }
}
