package info.ds.dp;

public class DP33EditDistance {

    private static int editDistanceRecursive(int i, int j, String s1, String s2) {
        if (j == 0) return i + 1;
        if (i == 0) return j + 1;

        if (s1.charAt(i) == s2.charAt(j)) return editDistanceRecursive(i - 1, j - 1, s1, s2);

        int replace = 1 + editDistanceRecursive(i - 1, j - 1, s1, s2);
        int insert = 1 + editDistanceRecursive(i, j - 1, s1, s2);
        int delete = 1 + editDistanceRecursive(i - 1, j, s1, s2);

        return Math.min(replace, Math.min(insert, delete));

    }

    //After index shifting , we will return i instead of i+1;
    private static int editDistanceMemo(int i, int j, String s1, String s2, int[][] dp) {
        if (j == 0) return i;
        if (i == 0) return j;

        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) return editDistanceMemo(i - 1, j - 1, s1, s2, dp);

        int replace = 1 + editDistanceMemo(i - 1, j - 1, s1, s2, dp);
        int insert = 1 + editDistanceMemo(i, j - 1, s1, s2, dp);
        int delete = 1 + editDistanceMemo(i - 1, j, s1, s2, dp);

        return dp[i][j] = Math.min(replace, Math.min(insert, delete));

    }

    private static int editDistanceTabulation(int n, int m, String s1, String s2) {
        //Index shifting
        n = n + 1;
        m = m + 1;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) dp[i][0] = i;
        for (int j = 0; j < m; j++) dp[0][j] = j;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int replace = 1 + dp[i - 1][j - 1];
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        return editDistanceRecursive(n - 1, m - 1, str1, str2);
    }
}
