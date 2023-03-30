package info.ds.dp;

public class DP34WildCardMatching {

    private static boolean wildCardRecursive(int i, int j, String s1, String s2){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(i>=0 && j<0) {
            for(int ii = 0 ;ii<=i;ii++){
                if(s1.charAt(ii)!='*') return false;
            }
            return true;
        }

        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?') return wildCardRecursive(i-1,j-1,s1,s2);

        if(s1.charAt(i)=='*') return wildCardRecursive(i, j-1, s1, s2) || wildCardRecursive(i-1, j, s1, s2);

        return false;
    }

    private static boolean wildCardMemo(int i,int j,String s1,String s2,int dp[][]){
        if(i==0 && j==0) return true;
        if(i==0 && j>=1) return false;
        if(i>=1 && j==0) {
            for(int ii = 0 ;ii<i;ii++){
                if(s1.charAt(ii)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1?true:false ;
        if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
            boolean match = wildCardMemo(i-1,j-1,s1,s2,dp);
            dp[i][j] = match==true?1:0;
            return match;

        }
        if(s1.charAt(i-1)=='*'){
            boolean considerEmpty =  wildCardMemo(i-1, j, s1, s2,dp);
            boolean considerChar = wildCardMemo(i, j-1, s1, s2,dp);
            boolean res = considerChar || considerEmpty;
            dp[i][j] = res==true?1:0;
            return res;
        }

        return false;
    }

    private static boolean wildCardTabulation(int n , int m , String s1,String s2){

        n=n+1;
        m=m+1;

        boolean dp[][] = new boolean[n][m];
        dp[0][0] = true;
        for(int j = 1;j<m;j++) dp[0][j] = false;
       //Last base case.//For every i>1 and j=0 , if char is * , dp[i][0] = true else false;
        for(int i=1;i<n;i++){
            boolean flag = true;
            for(int ii=0;ii<i;ii++){
                if(s1.charAt(ii)!='*') {
                    flag=false;
                    break;
                }
            }
            dp[i][0]=flag;
        }

        for(int i=1;i<n;i++){
            for(int j =1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];

                }
                if(s1.charAt(i-1)=='*'){
                    boolean considerEmpty =  dp[i-1][j];
                    boolean considerChar = dp[i][j-1];
                    boolean res = considerChar || considerEmpty;
                    dp[i][j] = res;

                }
            }
        }
        return dp[n-1][m-1];
    }

    public static boolean wildcardMatching(String pattern, String text) {
        int n = pattern.length();
        int m =text.length();

        return wildCardRecursive(n-1, m-1, pattern, text);
    }
}
