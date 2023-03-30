package info.ds.dp;

public class DP27LongestCommonSubstring {

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        //Index shifting
        n=n+1;
        m=m+1;

        int dp[][] = new int[n][m];
        int max = (int) -1e9;
        //Since base case is dp[i][0]=0 and dp[0][j]=0; out dp is already initiazlized with 0

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else dp[i][j]=0; //Since this is substring we cannot skip elements otherwise it will not be substring.
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                max = Math.max(dp[i][j],max);
            }
        }

        return max;
    }
}
