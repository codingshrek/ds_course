package info.ds.dp;

public class DP36BuySellStock2 {

    private static long f(int i, int buy, int n, long[] prices, long dp[][]) {
        if (i == n) return 0; //We do not have any shares to buy or sell thus no profit.

        if (dp[i][buy] != -1) return dp[i][buy];
        long profit = 0;
        if (buy == 1) {
            long buying = f(i + 1, 0, n, prices, dp) - prices[i];
            long notBuying = f(i + 1, 1, n, prices, dp);
            profit = Math.max(buying, notBuying);
        } else {
            long sell = f(i + 1, 1, n, prices, dp) + prices[i];
            long notSell = f(i + 1, 0, n, prices, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[i][buy] = profit;

    }

    private static long tabulation(int n, long[] prices) {

        long[] ahead = new long[2];
        long[] cur = new long[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                long profit = 0;
                if (buy == 1) {
                    long buying = ahead[0] - prices[i];
                    long notBuying = ahead[1];
                    profit = Math.max(buying, notBuying);
                } else {
                    long sell = ahead[1] + prices[i];
                    long notSell = ahead[0];
                    profit = Math.max(sell, notSell);
                }

                cur[buy] = profit;

            }
            ahead = cur;
        }

        return cur[1];
    }

    private static long tabulation4Variable(int n, long[] prices) {

        long aheadBuy = 0;
        long aheadNotBuy = 0;
        long curBuy = 0;
        long curNotBuy = 0;

        for (int i = n - 1; i >= 0; i--) {

            //Instead of runnig Buy loop 0->1 both are calculated same time.

            //Buy
            long buying = aheadNotBuy - prices[i];
            long notBuying = aheadBuy;
            curBuy = Math.max(buying, notBuying);

            //Not buy
            long sell = aheadBuy + prices[i];
            long notSell = aheadNotBuy;
            curNotBuy = Math.max(sell, notSell);


            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }

        return curBuy;
    }

    public static long getMaximumProfit(int n, long[] values) {
        /*long dp[][] = new long[n][2];
        for(long[] row : dp) Arrays.fill(row,-1);
        return f(0,1,n,values,dp);*/
        return tabulation(n, values);
    }
}
