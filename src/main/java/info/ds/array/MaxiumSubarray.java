package info.ds.array;

/**
 * Kadanes Algo.
 */
public class MaxiumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = 0;
        int i=0;
        while(i<nums.length){
            if(sum+nums[i]<=0){
                sum=0;
            }
            else{
                sum = sum+nums[i];
                max = Math.max(max,sum);
            }
            i++;
        }

        if(max==0){
            i=0;
            max = Integer.MIN_VALUE;
            while(i<nums.length){
                max = Math.max(nums[i],max);
                i++;
            }
        }
        return max;
    }

}
