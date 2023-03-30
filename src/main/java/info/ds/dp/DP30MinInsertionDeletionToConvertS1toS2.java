package info.ds.dp;

public class DP30MinInsertionDeletionToConvertS1toS2 {

    public static int lcs(String s1,String s2){

        int n = s1.length();
        int m = s2.length();
        //index shifting
        n=n+1;
        m=m+1;

        int[][] dp = new int[n][m];

        //Base Case dp[0][j]=0 and dp[i][0]=0 , since it is already initialized to 0 not doing anything.


        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];

    }

    public static int canYouMake(String str, String ptr) {
        int n = str.length();
        int m = ptr.length();

        int lcs = lcs(str,ptr);

        int ans = (n+m) - (2*lcs); //Watch your notes on one note.

        return ans;
    }

}
