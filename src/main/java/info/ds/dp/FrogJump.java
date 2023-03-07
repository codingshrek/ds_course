package info.ds.dp;

public class FrogJump {

    //Memoization
    private static int jumps(int index, int heights[], int dp[]) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) return dp[index];
        int right = Integer.MAX_VALUE;
        int left = jumps(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        if (index > 1) right = jumps(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        int min = Math.min(right, left);
        dp[index] = min;
        return min;
    }

    //Tabulation
    private static int jumpsTabulation(int n, int heights[], int dp[]) {

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int right = Integer.MAX_VALUE;
            int left = dp[i-1] +  Math.abs(heights[i] - heights[i - 1]);
            if(i>1) right = dp[i-2] +  Math.abs(heights[i] - heights[i - 2]);
            int min = Math.min(left,right);
            dp[i]=min;
        }
        return dp[n-1];
    }

    public static int frogJump(int n, int heights[]) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        int min = jumps(n - 1, heights, dp);
        return min;
    }

}
