package info.ds.dp;

import java.util.ArrayList;

public class DP35BuySellStock1 {

    public static int maximumProfit(ArrayList<Integer> prices){
        //If I am selling the stock at ith day , I must buy it on the min price from 0->i-1
        int n = prices.size();
        int maxProfit = 0;
        int minPrice = prices.get(0);
        for(int i=1;i<n;i++){
            int profit = prices.get(i)-minPrice;
            maxProfit = Math.max(profit,maxProfit);
            minPrice = Math.min(minPrice,prices.get(i)); //Keeping track of min buying price  from 0->i-1
        }

        return maxProfit;

    }
}


