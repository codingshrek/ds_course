package info.ds.dp;

public class Dp22CoinChange2 {

    public static long countWays(int index,int target,int[] dnm,long[][] dp){

        if(index==0){
            if(target==0) return 1;
            if(target%dnm[0]==0) return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        long notTake = countWays(index-1,target,dnm,dp);
        long take = 0;
        if(target>=dnm[index]) take= countWays(index,target-dnm[index],dnm,dp);

        return dp[index][target]=take+notTake;
    }

    public static long countWaysTabulation(int n , int value , int[] dnm){

        long[][] dp =  new long[n][value+1];
        dp[0][0]=1;
        for(int i=dnm[0];i<=value;i++) {
            if(i%dnm[0]==0) dp[0][i]=1;
        }
        for(int index =1;index<n;index++){
            for(int target=0;target<=value;target++){
                long notTake = dp[index-1][target];
                long take = 0;
                if(target>=dnm[index]) take= dp[index][target-dnm[index]];
                dp[index][target]= take+notTake;
            }
        }
        return dp[n-1][value];
    }

    public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
		/*long dp[][] = new long[n][value+1];
		for(long[] row:dp){
			Arrays.fill(row,-1);
		}
 		return countWays(n-1, value, denominations,dp);	*/
        return countWaysTabulation(n,value,denominations);

    }

}
