package info.ds.dp;

import java.util.Arrays;

public class LongestCommonSubsequenceDP25 {

    public static int lcsMemo(int i , int j , String s1, String s2,int[][] dp){
        //if(i<0||j<0) return 0; //not used just for explanation
        if(i==0||j==0) return 0; //right shifting indexes
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=1+lcsMemo(i-1,j-1,s1,s2,dp);

        return dp[i][j]=Math.max(lcsMemo(i-1,j,s1,s2,dp),lcsMemo(i,j-1,s1,s2,dp));

    }

    public static int lcsTabulation(int n , int m ,String s1, String s2){
        n=n+1;//right shifting indexes;
        m=m+1;//right shifting indexes;
        int[][] dp = new int[n][m];
        for(int j = 0;j<m;j++) dp[0][j]=0; // since indexes are right shifted 0 means -1 , thus this is the case where i<0
        for(int i = 0;i<n;i++) dp[i][0]=0; //Similar as above;

        for(int i = 1;i<n;i++){
            for(int j =1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n-1][m-1];

    }
    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();
        //int[][] dp = new int [n][m]; not used just for explanation
        int[][] dp = new int [n+1][m+1]; //Since base case is for -ve parameters , we need shift indexes to right
        // ie -1 -> 0 , i-> i-1 and j-> j-1. So that we can write the tabulation as dp[-1][j] will not make sense.
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        //return lcsMemo(n-1,m-1,s,t,dp); //n-1 -> n and m-1 -> m , right shifting indexes . not used just for explanation
        //return lcsMemo(n,m,s,t,dp);
        return lcsTabulation(n,m,s,t);
    }

}
