package info.ds.binary_search;

public class KokoEatingBananas {
    public static int minimumRateToEatBananas(int[] v, int h) {
        int max = findMax(v);
        int low = 0;
        int high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkIfPossible(v, mid, h)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }


    /**
     * to check if h hours can be possible.
     */
    private static Boolean checkIfPossible(int[] piles, int h, int maxH) {
        double tH = 0;
        for (int p : piles) {
            tH += Math.ceil((double) p / (double) h);
            if (tH > maxH) return false;
        }
        return true;
    }


    private static int findMax(int piles[]) {
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(max, p);
        }
        return max;
    }

}
