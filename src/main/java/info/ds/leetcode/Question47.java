package info.ds.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Permute unique
 */
public class Question47 {

    public List<List<Integer>> findAllThePermutations(int index, int nums[], List<List<Integer>> res) {

        if (index >= nums.length) {

            List<Integer> integers = new LinkedList<>();
            for (int t : nums) {
                integers.add(t);
            }
            res.add(integers);
            return res;
        }


        //This set contains record of which number is placed at ith position. If at first position 1 is used , same combination should not be used.
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(new Integer(nums[i]))) continue;
            set.add(new Integer(nums[i]));
            swap(nums, i, index);
            findAllThePermutations(index + 1, nums, res);
            //Backtrack transition
            swap(nums, i, index);
        }
        return res;
    }

    private int[] swap(int[] nums, int i, int j) {

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return nums;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        return findAllThePermutations(0, nums, new LinkedList<>());
    }

    public static void main(String[] args) {
        Question47 q = new Question47();
        List<List<Integer>> res = q.permuteUnique(new int[]{1,1,2});

        res.forEach(integers -> System.out.println(integers));

    }
}
