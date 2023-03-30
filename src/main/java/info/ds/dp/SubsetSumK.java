package info.ds.dp;

public class SubsetSumK {

    //Recursion -> 2^n
    //Memoization -> n*k
    public static boolean subsetSumMemoization(int index,int target,int arr[],int[][] dp){
        if(target==0) return true;
        if(index==0) return (target == arr[index]);
        if(dp[index][target]!=-1) return dp[index][target]==1?true:false;
        boolean notTake = subsetSumMemoization(index-1, target, arr,dp);
        boolean take = false;
        if(target>=arr[index]) take = subsetSumMemoization(index-1, target-arr[index], arr,dp);

        boolean res = take || notTake;
        if(res==true) dp[index][target]=1;
        else dp[index][target] = 0;
        return res;
    }

    public static boolean subsetSumTabulation(int n,int target,int arr[]){
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }
        if(target>arr[0]) dp[0][arr[0]] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(j>=arr[i]) take = dp[i-1][j-arr[i]];

                boolean res = take || notTake;
                dp[i][j] = res;
            }
        }

        return dp[n-1][target];
    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        /*int dp[][] = new int[n+1][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j]=-1;
            }

        }
        return subsetSumMemoization(n-1,k,arr,dp);*/
        return subsetSumTabulation(n,k,arr);
    }

}
