package info.ds.array_string.sliding_window;

public class LargestSubArraySum {

    public int largestSubArraySum(int[] arr, int k) {

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

    public static void main(String[] args) {

        int arr[] = {4, 1, 1, 1, 2, 3, 5};
        LargestSubArraySum largestSubArray = new LargestSubArraySum();
        System.out.println(largestSubArray.largestSubArraySum(arr, 5));
        ;
    }

}
