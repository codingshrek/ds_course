package info.ds.dp;

//Similar to DP 37 , Cooldown means if i have sold the stock on ith day, I cannot buy stock on i+1 day. I am allowed to buy stock from i+2 day.
public class DP39BuySellStock4CoolDown {
    private static int f(int i,int buy,int n ,int[] prices,int[][] dp){

        if(i>=n) return 0;

        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit = 0;
        //allowed to buy
        if(buy==1){
            int buying = f(i+1,0,n,prices,dp)-prices[i];
            int notBuying = f(i+1,1,n,prices,dp);
            profit =Math.max(buying,notBuying);
        }
        //Not allowed to buy. Holding a stock
        else{
            int selling = f(i+2,1,n,prices,dp)+prices[i];
            int notSelling= f(i+1,0,n,prices,dp);
            profit = Math.max(selling,notSelling);
        }

        return dp[i][buy]=profit;

    }

    private static int tabulation(int n , int[] prices){
        int[][] dp = new int[n+2][2];
        for(int buy=0;buy<=1;buy++){
            dp[n][buy]=0;
            dp[n+1][buy]=0;
        }

        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                int profit =0 ;
                if(buy==1){
                    int buying = dp[i+1][0]-prices[i];
                    int notBuying = dp[i+1][1];
                    profit =Math.max(buying,notBuying);
                }
                else{
                    int selling = dp[i+2][1]+prices[i];
                    int notSelling = dp[i+1][0];
                    profit = Math.max(selling,notSelling);
                }
                dp[i][buy] = profit;

            }
        }

        return dp[0][1];
    }

    //After removing inner loop.
    private static int tabulationOptimized(int n , int[] prices){
        int[][] dp = new int[n+2][2];
        for(int buy=0;buy<=1;buy++){
            dp[n][buy]=0;
            dp[n+1][buy]=0;
        }

        //Calculating buy, and sell at once without loop
        for(int i=n-1;i>=0;i--){
            //Buy
            int buying = dp[i+1][0]-prices[i];
            int notBuying = dp[i+1][1];
            dp[i][1] =Math.max(buying,notBuying);

            //Sell
            int selling = dp[i+2][1]+prices[i];
            int notSelling = dp[i+1][0];
            dp[i][0] = Math.max(selling,notSelling);

        }

        return dp[0][1];
    }

    public static int stockProfit(int[] prices) {
        int n = prices.length;
		/*int[][] dp = new int[n][2];

		for(int[] row : dp) Arrays.fill(row,-1);
		return f(0,1,n,prices,dp);*/
        return tabulation(n,prices);
    }
}
