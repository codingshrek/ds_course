package info.ds.dp;

import java.util.Arrays;

public class TargetSumDp21 {

    private static int targetSumMemo(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (arr[0] == target || target == 0) return 1;
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notTake = targetSumMemo(index - 1, target, arr, dp);
        int take = 0;
        if (target >= arr[index]) take = targetSumMemo(index - 1, target - arr[index], arr, dp);

        return dp[index][target] = take + notTake;
    }

    private static int targetSumTabulation(int n, int t, int[] arr) {
        int[][] dp = new int[n][t + 1];
        dp[0][0] = 1;
        if (arr[0] == 0) dp[0][0] = 2;
        if (arr[0] <= t && arr[0] != 0) dp[0][arr[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= t; target++) {
                int notTake = dp[index - 1][target];
                int take = 0;
                if (target >= arr[index]) take = dp[index - 1][target - arr[index]];
                dp[index][target] = take + notTake;
            }
        }

        return dp[n - 1][t];
    }

    public static int targetSum(int n, int target, int[] arr) {
        int total = 0;
        for (int i = 0; i < n; i++) total += arr[i];

        if ((total + target) % 2 != 0) return 0;

        int t = (total + target) / 2;

        int[][] dp = new int[n][t + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        //return targetSumMemo(n-1,t,arr,dp);
        return targetSumTabulation(n, t, arr);


    }

}
