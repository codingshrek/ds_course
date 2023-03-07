package info.ds.dp;

/**
 *
 * The dp[n-1][target+1] signifies that dp[n-1][i] where i->0->targetSum if this value is true then we have a subset till index 0->n-1 with sum i.
 * We need two partitions here s1 and s2 . If we find all the possible subset sum values of s1 then we can calculate s2 as target-s1.
 * How to find the all possible values of s1? The dp table can be used. dp[n-1][i].
 * Min of |s1-s2| = min(|s1-(target-s1)|)
 */
public class PartitionSetMinSubsetSum {

    public static int minSubsetSumDifference(int[] arr, int n) {
        int tSum = 0;
        for(int i=0;i<n;i++){
            tSum+=arr[i];
        }

        boolean dp[][] = new boolean[n][tSum+1];

        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(tSum>=arr[0]) dp[0][arr[0]]=true;

        for(int index = 1;index<n;index++){
            for(int target =1 ;target<=tSum;target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(target>=arr[index]) take = dp[index-1][target-arr[index]];
                boolean res = take || notTake;
                dp[index][target] = res;
            }
        }

        int min = (int)1e8;
        for(int i=0;i<=tSum;i++){
            boolean s1 = dp[n-1][i];
            if(s1==true){
                min = Math.min(min,Math.abs(i-(tSum-i)));
            }
        }

        return min;
    }
}
