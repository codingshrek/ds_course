package info.ds.dp;

public class MinimumCoinsDP20 {

    private static int minimumElementsMemo(int index,int target,int num[],int[][] dp){
        if(index==0){
            if(target%num[0]==0) return target/num[0];
            return (int)1e9;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int take = (int)1e9;
        if(target>=num[index]) take = 1+minimumElementsMemo(index, target-num[index], num,dp);
        int notTake = minimumElementsMemo(index-1, target, num,dp);

        return dp[index][target]=Math.min(take,notTake);
    }
    public static int minimumElementsTabulation(int n,int x,int num[]) {

        int[][] dp = new int[n][x+1];

        for(int i=1;i<=x;i++){
            dp[0][i] = (int)1e9;
        }

        for(int i=num[0];i<=x;i++){
            if(i%num[0]==0) dp[0][i]=i/num[0];
            else dp[0][i] = (int)1e9;
        }

        for(int index=1;index<n;index++){
            for(int target=0;target<=x;target++){
                int take = (int)1e9;
                if(target>=num[index]) take = 1+dp[index][target-num[index]];
                int notTake = dp[index-1][target];
                dp[index][target] = Math.min(take,notTake);
            }
        }

        if(dp[n-1][x]>=1e9) return -1;
        return dp[n-1][x];
    }
    public static int minimumElements(int num[], int x) {
        int n = num.length;
        /*int[][] dp = new int[n][x+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        int ans = minimumElementsMemo(n-1, x, num,dp);
        if(ans>=1e9) return -1;
        return ans;*/
        return minimumElementsTabulation(n,x,num);
    }

}
