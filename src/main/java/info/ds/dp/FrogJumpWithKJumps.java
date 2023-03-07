package info.ds.dp;

public class FrogJumpWithKJumps {

    public static int frogJumRecursive(int index, int k, int[] heights) {
        if (index == 0) return 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = frogJumRecursive(index - i, k, heights) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(jump, min);
            }
        }

        return min;
    }

    //Memoization
    //TC-> n*k
    //SC -> n+n for dp and re stack.
    public static int frogJumMemoizationDp(int index, int k, int[] heights,int dp[]) {
        if (index == 0) return 0;
        if(dp[index]!=-1) return dp[index];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int jump = frogJumRecursive(index - i, k, heights) + Math.abs(heights[index] - heights[index - i]);
                min = Math.min(jump, min);
            }
        }
        dp[index]=min;
        return min;
    }

    public static int frogJump(int n, int k, int[] heights) {
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        dp[0]=0;
        //return frogJumRecursive(n-1, k, heights);
        //return frogJumMemoizationDp(n-1, k, heights,dp);
        return frogJumpTabulationDp(n,k,heights,dp);
    }

    //TC->n*k
    //n for dp array
    public static int frogJumpTabulationDp(int n , int k , int[] heights, int[] dp){
        dp=new int[n];
        for(int i=1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int jump = dp[i-j]+Math.abs(heights[i]-heights[i-j]);
                    min = Math.min(min,jump);
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

        /*int heights[] = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k = 4;
        int n = 10;*/

        int heights[] = {10,10};
        int k = 100;
        int n = 2;
        System.out.println(frogJump(n, k, heights));
        System.out.println(frogJump(n, k, heights));
        System.out.println(frogJump(n,k,heights));
    }
}
