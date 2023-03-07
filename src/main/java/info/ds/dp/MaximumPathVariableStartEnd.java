package info.ds.dp;
//https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
public class MaximumPathVariableStartEnd {

    //TC > Recursion -> 3^n
    public static int getMaxPathMemoization(int row,int col,int n, int m,int[][] matrix,int[][] dp){
        if(col<0 || col>=m) return (int)Math.pow(10,9)*(-1);
        if(row==n-1)return matrix[n-1][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int down = matrix[row][col]+getMaxPathMemoization(row+1,col,n,m,matrix,dp);
        int downLeft = matrix[row][col]+getMaxPathMemoization(row+1,col-1,n,m,matrix,dp);
        int downRight = matrix[row][col]+getMaxPathMemoization(row+1,col+1,n,m,matrix,dp);
        return dp[row][col]=Math.max(down,Math.max(downLeft,downRight));
    }

    public static int getMaxPathSumTabulation(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for(int j=0;j<m;j++){
            dp[n-1][j] = matrix[n-1][j];
        }

        for(int row =n-2;row>=0;row--){
            for(int col = m-1;col>=0;col--){
                int down = matrix[row][col]+dp[row+1][col];
                int downLeft = (int)Math.pow(10,9)*(-1);
                int downRight = (int)Math.pow(10,9)*(-1);
                if(col>0)downLeft = matrix[row][col]+dp[row+1][col-1];
                if(col<m-1)downRight = matrix[row][col]+dp[row+1][col+1];
                dp[row][col] = Math.max(down,Math.max(downLeft,downRight));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(max,dp[0][i]);
        }
        return max;
    }

    public static int getMaxPathSum(int[][] matrix) {

		/*int n = matrix.length;
		int m = matrix[0].length;
		int max = Integer.MIN_VALUE;
		int[][] dp = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				dp[i][j] = -1;
			}
		}
		for(int i=0;i<m;i++){
			max=Math.max(getMaxPathMemoization(0, i, n,m, matrix, dp),max);
		}
		return max;*/
        return getMaxPathSumTabulation(matrix);
    }
}
