package info.ds.dp;

public class UniquePath {

    public static int uniquePathsMemoization(int row,int col,int[][] dp){
        if(row==0&&col==0) return 1;
        if(row<0 || col<0) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int left = uniquePathsMemoization(row, col-1, dp);
        int up = uniquePathsMemoization(row-1,col,dp);

        int totalWays = left+up;
        return dp[row][col] = totalWays;
    }

    public static int uniquePathsTablation(int m,int n){
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    dp[i][j]=1;
                    continue;
                }
                int down = 0;
                int right=0;
                if(i>0) down = dp[i-1][j];
                if(j>0) right = dp[i][j-1];

                dp[i][j] = down+right;
            }
        }
        return dp[m-1][n-1];
    }


    public static int uniquePathsTablationSO(int m,int n){
        int dp[] = new int[n]; //Upper row

        for(int i=0;i<m;i++){
            int temp[] = new int[n]; //current row
            for(int j=0;j<n;j++){
                if(i==0 && j==0) {
                    temp[j]=1;
                    continue;
                }

                int down = 0;
                int right=0;
                down = dp[j];
                if(j>0) right = temp[j-1];

                temp[j] = down+right;

            }
            dp = temp;
        }
        return dp[n-1];
    }

    public static int uniquePaths(int m, int n) {
		/*int dp[][] = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dp[i][j] = -1;
			}
		}
		dp[0][0]=1;
		uniquePathsMemoization(m-1, n-1, dp);*/

        return uniquePathsTablation(m,n);
    }
}
