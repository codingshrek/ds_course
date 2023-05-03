package info.ds.dp;

import java.util.Arrays;

public class DP50CostToCutRod {

    private static int cutsCost(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cuts[j + 1] - cuts[i - 1] + cutsCost(i, k - 1, cuts, dp) + cutsCost(k + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }

    private static int tab(int n, int c, int[] cuts) {

        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i > 0; i--) {
            for (int j = i; j <= c; j++) {
                if (i > j) continue;
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cuts[j + 1] - cuts[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }

    public static int cost(int n, int c, int cuts[]) {
        int[] temp = new int[c + 2];
        temp[0] = 0;
        Arrays.sort(cuts);
        for (int i = 1; i <= c; i++) {
            temp[i] = cuts[i - 1];
        }
        temp[c + 1] = n;

        /*int[][] dp = new int[c+1][c+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        return cutsCost(1,c,temp,dp);*/

        return tab(n, c, temp);
    }

}
