package info.ds.dp;

public class DP48NumberOfLongestLIS {

    public static int findNumberOfLIS(int n, int[] arr) {

        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int prev = 0; prev < i; prev++) {
                if (arr[i] > arr[prev] && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    cnt[i] = 1; //inehritting count

                } else if (arr[i] > arr[prev] && dp[i] == dp[prev] + 1) {
                    cnt[i] += cnt[prev];
                }
            }
            maxi = Math.max(dp[i], maxi);
        }
        int nos = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) nos += cnt[i];
        }

        return nos;
    }


}
