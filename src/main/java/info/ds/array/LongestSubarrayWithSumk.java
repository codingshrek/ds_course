package info.ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
 */
public class LongestSubarrayWithSumk {

    /**
     * @param Works for negetives as well
     * @param k
     * @return
     */
    public static int longestSubarrayWithSumK(int []a, long k) {

        long sum = 0;
        int max = Integer.MIN_VALUE;
        Map<Long,Integer> map =new HashMap<>();
        for(int i =0;i<a.length;i++){
            sum = sum+a[i];
            if(sum==k) max = Math.max(i+1,max);
            long rem = sum - k;
            if(map.containsKey(rem)){
                max =Math.max(i-map.get(rem),max);
            }
            if(!map.containsKey(sum))map.put(sum,i);

        }
        return max;
    }
}
