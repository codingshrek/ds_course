package info.ds.dp;
//Here starting point is fixed but ending point varies depending on which path we are taking.
//Thus we in recursion we are going 0->n-1.
public class MinPathSumTriangle {

    public static int minPathSumMemoization(int row,int col,int n,int[][] triangle,int[][] dp){
        //col could be either down or diagonal.
        if(row==n-1) {
            return triangle[n-1][col];
        }

        if(dp[row][col]!=-1) return dp[row][col];

        int down = triangle[row][col]+minPathSumMemoization(row+1,col,n,triangle,dp);
        int dg = triangle[row][col]+minPathSumMemoization(row+1,col+1,n,triangle,dp);

        return dp[row][col]=Math.min(down,dg);
    }

    //TC-> 2^ sum(1+2+3...n-1);
    public static int minPathSumTabulation(int n,int[][] triangle){
        int[][] dp= new int[n][n];
        for(int i = 0;i<n;i++){
            dp[n-1][i] = triangle[n-1][i];
        }
        //Thumb rule tabulation is always reverse of recursion.
        for(int row =n-2;row>=0;row--){
            for(int col=row;col>=0;col--){
                int down = triangle[row][col]+dp[row+1][col];
                int dg = triangle[row][col]+dp[row+1][col+1];
                dp[row][col] = Math.min(down,dg);
            }
        }

        return dp[0][0];
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        /*int[][] dp= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=-1;
            }
        }
        return minPathSumMemoization(0, 0,n, triangle, dp);*/
        return  minPathSumTabulation(n,triangle);
    }
}
