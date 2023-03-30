package info.ds.dp;

public class Knapsack {
    private static int knapsackMemoization(int index,int W,int[] weight,int[] value,int[][] dp){
        if(index==0){
            if(weight[0]<=W) return value[0];
            return 0;
        }
        if(dp[index][W]!=-1) return dp[index][W];
        int notTake = knapsackMemoization(index-1,W,weight,value,dp);
        int take = (int)-1e9;
        if(W>=weight[index]) take=value[index]+knapsackMemoization(index-1,W-weight[index],weight,value,dp);

        return dp[index][W]=Math.max(take,notTake);
    }

    private static int knapsackTabulation(int n , int maxWeight,int[] weight,int[] value){
        int[][] dp = new int[n][maxWeight+1];
        for(int i=weight[0];i<=maxWeight;i++) dp[0][i]=value[0]; // wt[0] <= W  , suppose wt[0]=5 and maxWt=10 , if W is 1-4 then we cannot pick
        //therefore anything from wt[0]-> maxWeight we can pick.

        for(int index =1;index<n;index++){
            for(int W =0;W<=maxWeight;W++){

                int notTake = dp[index-1][W];
                int take = (int)-1e9;
                if(W>=weight[index]) take=value[index]+dp[index-1][W-weight[index]];
                dp[index][W] = Math.max(take,notTake);
            }
        }

        return dp[n-1][maxWeight];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            /*int dp[][] = new int[n][maxWeight+1];
            for(int[] row : dp){
                Arrays.fill(row,-1);
            }

           return knapsackMemoization(n-1,maxWeight,weight,value,dp);*/
        return knapsackTabulation(n,maxWeight,weight,value);

    }

    public static void main(String[] args) {
        System.out.println(0%5);
    }
}
