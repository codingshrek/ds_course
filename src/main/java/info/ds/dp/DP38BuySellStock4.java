package info.ds.dp;

public class DP38BuySellStock4 {

    //Similar to DP 37 , instead of totalCap = 2 , here we have totalCap = k
    public static int maximumProfit(int[] prices, int n, int totalCap)
    {
        int[][] ahead = new int[2][totalCap+1];
        int[][] cur  = new int[2][totalCap+1];

        ahead[0][0]=0;
        ahead[1][0]=0;


        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=totalCap;cap>=1;cap--){
                    int profit = 0;
                    if(buy==1 && cap>0){
                        int buying = ahead[0][cap]-prices[i];
                        int notBuying = ahead[1][cap];
                        profit=Math.max(buying,notBuying);
                    }
                    else if(buy==0){
                        int selling = prices[i]+ahead[1][cap-1];
                        int notSelling =ahead[0][cap];
                        profit = Math.max(selling,notSelling);
                    }

                    cur[buy][cap]=profit;
                }
            }
            ahead = cur;
        }
        return cur[1][totalCap];
    }
}
