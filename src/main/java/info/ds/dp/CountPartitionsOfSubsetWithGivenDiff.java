package info.ds.dp;

//DP 18
public class CountPartitionsOfSubsetWithGivenDiff {
    private static int mod = (int)1e9+7;
    public static int countPartitionsMemoization(int index,int target,int[] arr,int[][] dp){

        if(index ==0){
            if(arr[0]==0 && target==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = countPartitionsMemoization(index-1, target, arr,dp);
        int take = 0;
        if(target>=arr[index]) take = countPartitionsMemoization(index-1, target-arr[index], arr,dp);

        return dp[index][target]=(take+notTake)%mod;
    }

    public static int countPartitionsTabulation(int n,int target,int[] arr) {

        int dp[][] = new int[n][target+1];
        if(arr[0]==0) dp[0][0]=2; //2 ways
        else dp[0][0]=1; //if arr[0]!=0 and target = 0 , there is only one way to not pick.

        if(arr[0]!=0 && target>=arr[0]) dp[0][arr[0]] =1;

        for(int index = 1;index<n;index++){
            for(int sum = 0 ;sum<=target;sum++){
                int notTake = dp[index-1][sum];
                int take = 0;
                if(sum>=arr[index]) take = dp[index-1][sum-arr[index]];
                dp[index][sum] = (take+notTake)%mod;
            }
        }

        return dp[n-1][target]%mod;
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int total = 0;
        for(int i=0;i<n;i++){
            total +=arr[i];
        }

        if((total+d)%2!=0) return 0;
        int target = (total+d)/2;

        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j]= -1;
            }
        }
        return countPartitionsTabulation(n, target, arr)%mod;
    }

}
