package info.ds.array;

/**
 * Leetcode 209.
 * Find the minimum length subarray whose sum equals k
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (j < n) {
            sum = sum + nums[j];
            if (sum >= target) {
                min = Math.min(min, j - i + 1);
                while (sum > target) {
                    sum = sum - nums[i];
                    i++;
                    if (sum >= target) {
                        min = Math.min(min, j - i + 1);
                    }
                }
                j++;
            } else {
                j++;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {


        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;

        while (j < n) {

            if (j - i + 1 <= indexDiff) {

                if (j != i && Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) return true;


                j++;
            } else {
                while (i < j) {

                    if (j != i && Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) return true;
                    i++;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumSizeSubArraySum sum = new MinimumSizeSubArraySum();
        System.out.println(sum.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }
}
