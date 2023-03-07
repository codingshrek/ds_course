package info.ds.dp;

public class ChocolatePickup3D {

    //TC-> Recursion -> 9* 3^n
    //TC-> n*m*m * 9 (all possible states)
    public static int maxChocolatesMemoization(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp){
        if(j1<0 || j2<0 || j1>=m || j2>=m){
            return (int)-1e8;
        }
        //We have reached last row
        if(i==n-1){
            //if bob and alice both reaches as same cell. We will only return 1 times.
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int max = (int)-1e8;
        //all possible paths
        for(int di=-1;di<=1;di++){
            for(int dj=-1;dj<=1;dj++){
                int path = (int)-1e8;
                if(j1==j2) path = grid[i][j1]+maxChocolatesMemoization(i+1,j1+di,j2+dj,n,m,grid,dp);
                else path = grid[i][j1]+grid[i][j2]+maxChocolatesMemoization(i+1,j1+di,j2+dj,n,m,grid,dp);
                max = Math.max(path,max);
            }
        }

        return dp[i][j1][j2]=max;
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {

        int[][][] dp=new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<c;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return maxChocolatesMemoization(0,0,c-1,r,c,grid,dp);
    }

}
