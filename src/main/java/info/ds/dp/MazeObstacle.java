package info.ds.dp;

import java.util.ArrayList;

public class MazeObstacle {

    static int mazeObstableMemoization(int row,int col,ArrayList<ArrayList<Integer>> mat,int[][] dp,int mod){
        if(row==0 && col ==0) return 1;
        if(row<0 || col<0 || mat.get(row).get(col)==-1) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        int left = mazeObstableMemoization(row,col-1,mat,dp,mod);
        int up = mazeObstableMemoization(row-1,col,mat,dp,mod);

        int total = (left+up)%mod;
        return dp[row][col]=total;
    }

    static int mazeObstableTabulation(int n, int m, ArrayList<ArrayList<Integer>> mat,int mod){
        int dp[][] = new int[n][m];
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                if(mat.get(i).get(j)==-1) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = (left+up)%mod;
            }
        }

        return dp[n-1][m-1];
    }

    static int mazeObstableTabulationSO(int n, int m, ArrayList<ArrayList<Integer>> mat,int mod){
        int dp[] = new int[m];

        for(int i=0;i<n;i++){
            int[] temp = new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0) {
                    temp[0]=1;
                    continue;
                }
                if(mat.get(i).get(j)==-1) {
                    temp[j] = 0;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i>0) up = dp[j];
                if(j>0) left = temp[j-1];
                temp[j] = (left+up)%mod;
            }
            dp=temp;
        }

        return dp[m-1];
    }


    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
       /*int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        dp[0][0]=1;*/
        int mod = 1000000007;
        //return mazeObstableMemoization(n-1, m-1, mat,dp,mod);
        return mazeObstableTabulationSO(n, m, mat,mod);
    }

}
