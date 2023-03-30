package info.ds.dp;

public class DP41LIS {

    public static int f(int i , int last,int n,int arr[],int[][] dp){
        if(i==n) return 0;
        if(dp[i][last+1]!=-1) return dp[i][last+1];
        int len = f(i+1,last,n,arr,dp);
        if(last ==-1 || arr[i]>arr[last]) len = Math.max(len,1+f(i+1,i,n,arr,dp));


        return dp[i][last+1]=len;
    }

    public static int tabulation(int n , int[] arr){
        int[] dp = new int[n+1];
        int[] cur = new int[n+1];
        //Base case is already 0;

        for(int i = n-1;i>=0;i--){
            for(int last =i;last>=-1;last--){
                int take = 0;
                if(last ==-1 || arr[i]>arr[last]) take= 1+dp[i+1];

                int notTake = dp[last+1];
                cur[last+1]=Math.max(take,notTake);
            }
            dp=cur;
        }
        return dp[0]; //0,-1+1
    }
    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
		/*int[][] dp = new int[n][n+1];
		for(int[] row:dp) Arrays.fill(row,-1);
		return f(0,-1,n,arr,dp);*/
        return tabulation(n,arr);
    }
}
