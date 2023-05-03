package info.ds.dp;

public class Dp48N49MCM {

    private static int mcm(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int steps = (arr[i-1]*arr[k]*arr[j]) + mcm(i,k,arr,dp)+mcm(k+1,j,arr,dp);
            min=Math.min(min,steps);
        }

        return dp[i][j]=min;
    }

    private static int tabulation(int n , int[] arr){
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=0;

        for(int i=n-1;i>0;i--){
            for(int j=i+1;j<n;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps = (arr[i-1]*arr[k]*arr[j]) + dp[i][k]+dp[k+1][j];
                    min=Math.min(min,steps);
                }
                dp[i][j]=min;
            }

        }
        return dp[1][n-1];
    }

    public static int matrixMultiplication(int[] arr , int N) {
		/*int[][] dp = new int[N][N];
		for(int[] row:dp) Arrays.fill(row,-1);
		return mcm(1,N-1,arr,dp);*/

        return tabulation(N,arr);
    }

}
