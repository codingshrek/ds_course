package info.ds.dp;
//https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
//https://amadeusworkplace-my.sharepoint.com/:o:/r/personal/akash_akash_amadeus_com/Documents/Notebooks/Akash%20@%20Work?d=w4081d6334036420fa830a6747ea25e79&csf=1&web=1&e=zgLiN1
public class PartitionSubsetWithEqualSum {


    private static boolean canPartitionMemoization(int index,int target,int[] arr,int[][] dp){
        if(target==0) return true;
        if(index==0){
            if(arr[index]==target) return true;
            return false;
        }
        if(dp[index][target]!=-1) return dp[index][target]==1?true:false;
        boolean notTake = canPartitionMemoization(index-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[index]) take = canPartitionMemoization(index-1, target-arr[index], arr,dp);
        boolean res = take || notTake;
        dp[index][target]=res==true?1:0;
        return res;
    }

    private static boolean canPartitionTabulation(int target,int n,int[] arr){
        boolean[][] dp = new boolean[n][target+1];
        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }
        if(target>arr[0]) dp[0][arr[0]]=true;

        for(int index =1;index<n;index++){
            for(int sum = 1;sum<=target;sum++){
                boolean notTake = dp[index-1][sum];
                boolean take = false;
                if(sum>=arr[index]) take = dp[index-1][sum-arr[index]];
                dp[index][sum] = take || notTake;
            }
        }

        return dp[n-1][target];
    }

    public static boolean canPartition(int[] arr, int n) {
		/*int total = 0;
		for(int i=0;i<n;i++){
			total+=arr[i];
		}
		if(total%2!=0) return false;
		int target = total/2;

		int[][] dp = new int[n][target+1];
		for(int i=0;i<n;i++){
			for(int j = 0;j<=target;j++){
				dp[i][j] = -1;
			}
		}
		return canPartitionMemoization(n-1, target, arr,dp);*/

        int total = 0;
        for(int i=0;i<n;i++){
            total+=arr[i];
        }
        if(total%2!=0) return false;
        int target = total/2;

        return canPartitionTabulation(target, n, arr);

    }

}
