package info.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int first = nums[i];
            int left = i + 1;
            int right = n - 1;
            int sum = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    ArrayList<Integer> t = new ArrayList<>();
                    t.add(first);
                    t.add(nums[left]);
                    t.add(nums[right]);
                    ans.add(t);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                } else if (nums[left] + nums[right] < sum) left++;
                else right--;

            }

        }

        return ans;
    }
}
