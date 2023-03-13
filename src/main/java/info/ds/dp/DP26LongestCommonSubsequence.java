package info.ds.dp;

//Continuation to DP25 . In this question we need to print the subsequence.
public class DP26LongestCommonSubsequence {

    public static char[] printLongestCommonSubsequence(int n , int m , String s1, String s2){
        n = n+1;
        m = m+1; //Shifting indexes
        int[][] dp = new int[n][m];

        //Base cases
        for(int j=0;j<m;j++) dp[0][j]=0;
        for(int i=0;i<n;i++) dp[i][0]=0;

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1]; //Condition 1
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); //condition 2
            }
        }

        int ansLength = dp[n-1][m-1]; //This is where the longest subsequence is
        char[] ans = new char[ansLength];
        int index = ansLength-1;

        int i=n-1;
        int j=m-1;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                System.out.println(s1.charAt(i-1));
                ans[index]=s1.charAt(i-1);
                index--;
                i--;j--;  // Since the answer is matching condition 1 must have been executed.
            }
            else if(dp[i-1][j]>=dp[i][j-1]) i--; //if dp[i-1][j]==dp[i][j-1] this means we have multiple answers and we can go anywhere.
            else j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2= "bdgek";
        int n = s1.length();
        int m = s2.length();

        System.out.println(printLongestCommonSubsequence(n,m,s1,s2));
    }
}
