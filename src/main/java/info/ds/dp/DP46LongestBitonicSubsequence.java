package info.ds.dp;

public class DP46LongestBitonicSubsequence {

    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];

        for (int i = 0; i < n; i++) {
            dp1[i] = 1; //initially every element is the LIS itself.
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && dp1[i] < dp1[prev] + 1) dp1[i] = dp1[prev] + 1;
            }
        }

        int[] dp2 = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1; //initially every element is the LIS itself.
            for (int prev = n - 1; prev > i; prev--) {
                if (arr[i] > arr[prev] && dp2[i] < dp2[prev] + 1) dp2[i] = dp2[prev] + 1;
            }
        }

        int maxi = 1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}
