package info.ds.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int maxLength = 0;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i] - 1)) {
                int cur = nums[i];
                int length = 1;
                while (set.contains(cur + 1)) {
                    length += 1;
                    cur += 1;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
