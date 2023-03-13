package info.ds.dp;

import java.util.Arrays;

public class DP29MinInsertionsRequiredToMakeStringPalindrome {


    private static int lps(int i, int j, String s1, String s2, int[][] dp) {
        //index shifting
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) return dp[i][j] = 1 + lps(i - 1, j - 1, s1, s2, dp);
        return dp[i][j] = Math.max(lps(i - 1, j, s1, s2, dp), lps(i, j - 1, s1, s2, dp));
    }

    public static int minInsertion(String str) {
        String s1 = str;
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();


        int dp[][] = new int[n + 1][n + 1];

        for (int[] row : dp) Arrays.fill(row, -1);
        int lps = lps(n, n, s1, s2, dp);

        //System.out.println("S1 : "+s1+"  S2  :  "+s2+"  LCS +  "+lps+"  n  "+n);

        return n - lps; // Length of String - length of lPS

    }
}
