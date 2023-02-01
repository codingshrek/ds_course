package info.ds.leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * Median of 2 sorted arrays
 */
public class Question4 {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;

        List<Integer> merged = new LinkedList<>();

        int i = 0;
        int j = 0;
        if (nums1.length >= nums2.length) {
            while (i < nums1.length) {
                while (j < nums2.length) {
                    if (j < nums2.length) {
                        if (nums1[i] == nums2[j]) {
                            merged.add(nums1[i]);
                            merged.add(nums1[i]);
                            i++;
                            j++;
                        } else if (nums1[i] < nums2[j]) {
                            merged.add(nums1[i]);
                            i++;
                        } else {
                            merged.add(nums2[j]);
                            j++;
                        }
                    } else {
                        merged.add(nums1[i]);
                        i++;
                    }

                }
            }

        }

        return median;


    }


    public static void main(String[] args) {
        int nums1[] = new int[]{1, 2};
        int nums2[] = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));


    }
}
