package info.ds.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/sliding-window-maximum/submissions/1173247371/
 * WHy Deque , use [1,3,1,2,0,5] dry run. i=1,j=3.
 */
public class MaxInSubArrayOfSizeK {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int c = 0;
        int i = 0;
        int j = 0;

        Deque<Integer> q = new ArrayDeque<>();
        while(j<n){
            while(!q.isEmpty() && nums[j]>q.peekLast()){
                q.removeLast();
            }
            q.addLast(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                ans[c] = q.peekFirst();
                c++;
                if(nums[i]==q.peekFirst()) q.removeFirst();
                i++;
                j++;

            }
        }

        return ans;

    }

}
