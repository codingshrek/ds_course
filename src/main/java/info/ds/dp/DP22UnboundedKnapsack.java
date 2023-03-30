package info.ds.dp;

public class DP22UnboundedKnapsack {

    public static int uKnapsack(int index,int w,int[] profit,int[] weight,int[][] dp){
        if(index==0){
            return ((int)w/weight[0])*profit[0];
        }
        if(dp[index][w]!=-1) return dp[index][w];
        int notTake = uKnapsack(index-1, w, profit, weight,dp);
        int take = (int)-1e9;
        if(w>=weight[index]) take = profit[index]+uKnapsack(index, w-weight[index], profit, weight,dp);

        return dp[index][w]=Math.max(take,notTake);
    }

    public static int uKnapsackTabulation(int n ,int maxWeight,int[] profit,int[] weight){
        int[][] dp = new int[n][maxWeight+1];

        for(int i=weight[0];i<=maxWeight;i++){
            dp[0][i] = ((int)i/weight[0])*profit[0];
        }

        for(int index = 1;index<n;index++){
            for(int w=0;w<=maxWeight;w++){
                int notTake = dp[index-1][w];
                int take = (int)-1e9;
                if(w>=weight[index]) take = profit[index]+dp[index][w-weight[index]];
                dp[index][w] = Math.max(take,notTake);
            }
        }
        return dp[n-1][maxWeight];
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        /*int dp[][] = new int[n][w+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return uKnapsack(n-1, w, profit, weight,dp);*/
        return uKnapsackTabulation(n,w,profit,weight);
    }
}
