package info.ds.dp;

public class MinimumPathSumInGrid {

    public static int traverseRecursive(int row,int col,int[][] grid,int[][] dp){
        if(row==0 && col==0) return grid[0][0];
        if(row<0 || col<0) return (int)Math.pow(10,9);
        if(dp[row][col]!=-1) return dp[row][col];
        int left = grid[row][col]+traverseRecursive(row,col-1,grid,dp);
        int up = grid[row][col]+traverseRecursive(row-1,col,grid,dp);

        return dp[row][col]=Math.min(left,up);
    }

    public static int minSumPathTabulation(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][] = new int[m][n];

        dp[0][0]=grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }
                int left = (int)Math.pow(10,9);
                int up = (int)Math.pow(10,9);
                if(i>0) up = grid[i][j]+dp[i-1][j];
                if(j>0) left = grid[i][j]+dp[i][j-1];
                dp[i][j] = Math.min(up,left);
            }
        }

        return dp[m-1][n-1];
    }

    public static int minSumPathTabulationSO(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            dp[i]=(int)Math.pow(10,9);
        }
        for(int i=0;i<m;i++){
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[0] = grid[0][0];
                    continue;
                }
                int left = (int)Math.pow(10,9);
                int up = (int)Math.pow(10,9);
                if(i>0) up = grid[i][j]+dp[j];
                if(j>0) left = grid[i][j]+temp[j-1];
                temp[j] = Math.min(up,left);
            }
            dp=temp;
        }

        return dp[n-1];
    }

    public static int minSumPath(int[][] grid) {
    	/*int m=grid.length;
        int n=grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=grid[0][0];*/

        //return traverseRecursive(m-1,n-1,grid,dp);
        return minSumPathTabulationSO(grid);
    }
}
