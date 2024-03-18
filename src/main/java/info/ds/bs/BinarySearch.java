package info.ds.bs;

public class BinarySearch {


    public static int binarySearchIterative(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int binarySearchRecursive(int low, int high, int target, int[] nums) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return binarySearchRecursive(low, mid - 1, target, nums);
        else return binarySearchRecursive(mid + 1, high, target, nums);

    }

    public static int search(int[] nums, int target) {
        return binarySearchRecursive(0, nums.length - 1, target, nums);
    }


}
