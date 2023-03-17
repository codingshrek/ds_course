package info.ds.dp;

import java.util.ArrayList;

public class DP37BuySellStock3 {

    public static int f(int i, int buy, int cap, int n, ArrayList<Integer> prices, int dp[][][]) {
        if (cap == 0) return 0;
        if (i == n) return 0;

        if (dp[i][buy][cap] != -1) return dp[i][buy][cap];
        int profit = 0;
        if (buy == 1 && cap > 0) {
            int buying = f(i + 1, 0, cap, n, prices, dp) - prices.get(i);
            int notBuying = f(i + 1, 1, cap, n, prices, dp);
            profit = Math.max(buying, notBuying);
        } else if (buy == 0) {
            int selling = prices.get(i) + f(i + 1, 1, cap - 1, n, prices, dp);
            int notSelling = f(i + 1, 0, cap, n, prices, dp);
            profit = Math.max(selling, notSelling);
        }

        return dp[i][buy][cap] = profit;

    }

    public static int tabulation(int n, int totalCap, ArrayList<Integer> prices) {

        int dp[][][] = new int[n + 1][2][totalCap + 1];
        for (int i = 0; i <= n; i++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= totalCap; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int cap = totalCap; cap >= 1; cap--) {
                    int profit = 0;
                    if (buy == 1 && cap > 0) {
                        int buying = dp[i + 1][0][cap] - prices.get(i);
                        int notBuying = dp[i + 1][1][cap];
                        profit = Math.max(buying, notBuying);
                    } else if (buy == 0) {
                        int selling = prices.get(i) + dp[i + 1][1][cap - 1];
                        int notSelling = dp[i + 1][0][cap];
                        profit = Math.max(selling, notSelling);
                    }

                    dp[i][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];

    }

    public static int tabulationMemoryOptimized(int n ,int totalCap,ArrayList<Integer> prices){



        int[][] ahead = new int[2][totalCap+1];
        int[][] cur  = new int[2][totalCap+1];

        ahead[0][0]=0;
        ahead[1][0]=0;


        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=totalCap;cap>=1;cap--){
                    int profit = 0;
                    if(buy==1 && cap>0){
                        int buying = ahead[0][cap]-prices.get(i);
                        int notBuying = ahead[1][cap];
                        profit=Math.max(buying,notBuying);
                    }
                    else if(buy==0){
                        int selling = prices.get(i)+ahead[1][cap-1];
                        int notSelling =ahead[0][cap];
                        profit = Math.max(selling,notSelling);
                    }

                    cur[buy][cap]=profit;
                }
            }
            ahead = cur;
        }
        return cur[1][2];

    }

    public static int maxProfit(ArrayList<Integer> prices, int n) {
		/*int dp[][][] = new int[n][2][3];
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				for(int k=0;k<3;k++){
					dp[i][j][k]=-1;
				}
			}
		}
		return f(0,1,2,n,prices,dp);*/
        return tabulation(n, 2, prices);

    }
}