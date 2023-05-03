package info.ds.dp;

public class DP51BurstBalloon {

    //Going opposite
    private static int f(int i , int j,int[] a,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i ;k<=j;k++){
            int coins = (a[i-1]*a[k]*a[j+1]) + f(i,k-1,a,dp)+f(k+1,j,a,dp);
            max = Math.max(max,coins);
        }
        return dp[i][j]=max;
    }

    private static int tab(int n,int[] a ){
        int[][] dp = new int[n+2][n+2];

        for(int i=n;i>0;i--){
            for(int j=i;j<=n;j++){
                int max = Integer.MIN_VALUE;
                for(int k = i ;k<=j;k++){
                    int coins = (a[i-1]*a[k]*a[j+1]) + dp[i][k-1]+dp[k+1][j];
                    max = Math.max(max,coins);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }


    public static int maxCoins(int a[]) {
        int n = a.length;
        int[] temp = new int[n+2];
        for(int i=1;i<=n;i++) temp[i]=a[i-1];
        temp[0]=1;
        temp[n+1]=1;
       /*int[][] dp = new int[n+2][n+2];
       for(int[] row: dp) Arrays.fill(row,-1);
       return f(1,n,temp,dp);*/
        return tab(n,temp);
    }
}
