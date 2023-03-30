package info.ds.dp;

public class DP32DistinctSubsequences {

    private static int mod = (int)Math.pow(10,9)+7;
    //Index shifted
    private static int countSubsequence(int i,int j,String s1,String s2,int[][] dp){
        if(j==0) return 1;
        if(i==0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=(countSubsequence(i-1,j-1,s1,s2,dp)+countSubsequence(i-1,j,s1,s2,dp))%mod;

        return dp[i][j]=countSubsequence(i-1,j,s1,s2,dp)%mod;
    }

    private static int countSubsequenceTabulation(int n , int m,String s1,String s2){
        n=n+1;
        m=m+1;

        int[][] dp = new int[n][m];

        //base case;

        for(int i =0;i<n;i++){
            dp[i][0] = 1;
        }

        for(int i =1;i<m;i++){
            dp[0][i] = 0;
        }

        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = (dp[i-1][j]+dp[i-1][j-1])%mod;
                else dp[i][j] = dp[i-1][j]%mod;
            }
        }
        return dp[n-1][m-1]%mod;
    }

    public static int subsequenceCounting(String t, String s, int lt, int ls) {
        /*int dp[][] = new int[lt+1][ls+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return countSubsequence(lt,ls,t,s,dp)%mod;*/
        return countSubsequenceTabulation(lt,ls,t,s)%mod;
    }

}
