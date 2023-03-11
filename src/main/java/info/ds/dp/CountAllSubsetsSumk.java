package info.ds.dp;

public class CountAllSubsetsSumk {

    //Recursion =-> TC-> 2^n
    //Memoization -> n*sum , SC-> n + (n*sum)
    public static int findWaysMemoization(int index, int target, int[] num, int dp[][]){

        if(index==0){
            if(target==0 && num[0]==0) return 2;
            if(target==0 ||target==num[0]) return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = findWaysMemoization(index-1, target, num,dp);
        int take =0;
        if(target>=num[index]) take = findWaysMemoization(index-1, target-num[index], num,dp);

        return dp[index][target]=take+notTake;
    }

    public static int findWaysTabulation(int n , int tar,int[] num){
        int[][] dp = new int[n][tar+1];

        if(num[0]==0) dp[0][0]=2;
        else dp[0][0] = 1;
        if(tar>=num[0] && num[0]!=0) dp[0][num[0]]=1;

        for(int index=1;index<n;index++){
            for(int target=0;target<=tar;target++){
                int notTake = dp[index-1][target];
                int take =0;
                if(target>=num[index]) take = dp[index-1][target-num[index]];
                dp[index][target] = take+notTake;
            }
        }
        return dp[n-1][tar];
    }



    public static int findWays(int num[], int tar) {
        int n=num.length;
        int[][] dp = new int[n][tar+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=tar;j++){
                dp[i][j]=-1;
            }
        }
        //return findWaysMemoization(n-1, tar, num,dp);
        return findWaysTabulation(n,tar,num);

    }
}
