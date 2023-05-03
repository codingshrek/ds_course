package info.ds.array.sw;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArraySum {

    public static int largestSubArraySum(int[] arr, int k) {

        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int sum = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (sum == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (sum < k) {
                j++;
            } else {
                while (sum > k) {
                    sum = sum - arr[i];
                    i++;
                    if(sum == k){
                        max = Math.max(max, j - i + 1);
                    }

                }
                j++;
            }

        }
        return max;
    }

    //Works for negatives as well
    public static int largestSubArraySumMap(int[] nums,int k){

        int n = nums.length;
        int sum = 0;
        int len = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<n;i++){

            sum = sum+nums[i];

            if(sum==k) len =Math.max(len,i+1);

            int rem = sum-k;

            if(map.containsKey(rem)){
                len = Math.max(len,i-map.get(rem));
                map.put(sum,i);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }


        }
        return len;
    }


    public static void main(String[] args) {

        int arr[] = {9, -1, -1, -1, -2, 3, -5};
        System.out.println(LargestSubArraySum.largestSubArraySumMap(arr,4));

    }

}
