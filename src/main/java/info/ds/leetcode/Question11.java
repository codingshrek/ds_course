package info.ds.leetcode;

public class Question11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {

                int left = height[i];
                int right = height[j];
                int length = j - i;
                int capacity = Math.min(left, right) * length;
                if (capacity > max) {
                    max = capacity;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question11 q = new Question11();
       // System.out.println(q.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(q.maxArea(new int[]{1,1}));

    }
}
