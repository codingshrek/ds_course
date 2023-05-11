package info.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int low = j + 1;
                int high = n - 1;

                while (low < high) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);

                        ans.add(temp);

                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;

                    } else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return ans;

    }
}
