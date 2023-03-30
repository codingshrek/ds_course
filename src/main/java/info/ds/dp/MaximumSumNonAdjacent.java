package info.ds.dp;

import java.util.ArrayList;

public class MaximumSumNonAdjacent {

    private static int findMaxMemoization(int index, ArrayList<Integer> nums, int[] dp){
        if(index==0) return nums.get(0);
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int take = nums.get(index)+ findMaxMemoization(index-2,nums,dp);
        int notTake = 0+ findMaxMemoization(index-1,nums,dp);
        return dp[index]=Math.max(take,notTake);

    }

    private static int findMaxTabulation(ArrayList<Integer> nums){
        int n = nums.size();
        int dp[] = new int[n];
        dp[0]=nums.get(0);
        for(int i =1;i<n;i++){
            int take=nums.get(i);
            if(i>1) take = nums.get(i)+dp[i-2];
            int notTake = 0+dp[i-1];
            int max = Math.max(take,notTake);
            dp[i]=max;
        }
        return dp[n-1];
    }

    private static int findMaxTabulationSO(ArrayList<Integer> nums){
        int n = nums.size();
        int prev = nums.get(0);
        int prev1= 0;
        for(int i =1;i<n;i++){
            int cur = nums.get(i);
            int take=cur;
            if(i>1) take = nums.get(i)+prev1;
            int notTake = 0+prev;
            int max = Math.max(take,notTake);

            prev1=prev;
            prev=max;

        }
        return prev;
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return findMaxTabulation(nums);
    }

}
