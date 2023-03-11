package info.ds.dp;

import java.util.Arrays;

public class RodCuttingDp24 {

    private static int cutRodMemo(int index,int length,int[] price,int[][] dp){

        if(index==0) return length*price[0];
        if(dp[index][length]!=-1) return dp[index][length];
        int notCut= cutRodMemo(index-1,length,price,dp);
        int cut = (int) -1e9;
        if(length>=index+1) cut = price[index]+cutRodMemo(index,length-(index+1),price,dp);

        return dp[index][length]=Math.max(cut,notCut);


    }

    private static int cutRodTabulation(int n,int[] price){

        int[][] dp =new int[n][n+1];
        for(int i=1;i<n+1;i++) dp[0][i] = (i)*price[0];

        for(int index =1;index<n;index++){
            for(int length=0;length<=n;length++){
                int notCut= dp[index-1][length];
                int cut = (int) -1e9;
                if(length>=index+1) cut = price[index]+dp[index][length-(index+1)];
                dp[index][length] = Math.max(cut,notCut);
            }
        }

        return dp[n-1][n];

    }

    public static int cutRod(int price[], int n) {
		/*int[][] dp = new int[n][n+1];
		for(int[] row:dp){
			Arrays.fill(row,-1);
		}
		return cutRodMemo(n-1,n,price,dp);*/
        return cutRodTabulation(n,price);
    }

    public static void main(String[] args) {
        int price[] = {2,5,7,8,10};

        int n = price.length;

        System.out.println("The Maximum price generated is "+cutRod(price,n));
    }
}
