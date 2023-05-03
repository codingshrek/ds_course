package info.ds.array.sw;

public class ArrangeNumberPosNegInOrder {

    public int[] rearrangeArray(int[] nums) {
        int neg = 1;
        int pos = 0;
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

}
