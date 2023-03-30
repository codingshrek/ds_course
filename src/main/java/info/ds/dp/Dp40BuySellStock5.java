package info.ds.dp;

//Similat to DP 37 , just transaction fee is included
public class Dp40BuySellStock5 {
    public static int f(int i, int buy, int fee, int n, int[] prices, int[][] dp) {
        if (i == n) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(f(i + 1, 0, fee, n, prices, dp) - prices[i], f(i + 1, 1, fee, n, prices, dp));
        } else {
            profit = Math.max(f(i + 1, 1, fee, n, prices, dp) + prices[i] - fee, f(i + 1, 0, fee, n, prices, dp));
        }
        return dp[i][buy] = profit;

    }

    public static int tabulation(int n, int fee, int[] prices) {
        int[][] dp = new int[n + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(dp[i + 1][0] - prices[i], dp[i + 1][1]);
                } else {
                    profit = Math.max(dp[i + 1][1] + prices[i] - fee, dp[i + 1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    //Space and inner loop optimized
    public static int tabulationOptimized(int n, int fee, int[] prices) {
        int[] ahead = new int[2];
        int[] cur = new int[2];

        for (int i = n - 1; i >= 0; i--) {

            //Buy
            cur[1] = Math.max(ahead[0] - prices[i], ahead[1]);
            //Sell
            cur[0] = Math.max(ahead[1] + prices[i] - fee, ahead[0]);

            ahead = cur;
        }
        return ahead[1];
    }

    public static int maximumProfit(int n, int fee, int[] prices) {
		/*int dp[][] = new int[n][2];
		for(int[] row : dp) Arrays.fill(row,-1);
		return f(0,1,fee,n,prices,dp);*/
        return tabulation(n, fee, prices);
    }
}
