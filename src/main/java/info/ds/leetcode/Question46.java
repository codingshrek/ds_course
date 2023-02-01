package info.ds.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutation
 */
public class Question46 {


    public List<List<Integer>> findAllThePermutations(int nums[], boolean[] choice, List<Integer> ds, List<List<Integer>> res) {

        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (choice[i] == false) {
                choice[i] = true;
                ds.add(nums[i]);
                findAllThePermutations(nums, choice, ds, res);

                ds.remove(ds.size() - 1);
                choice[i] = false;
            }
        }
        return res;
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean choice[] = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            choice[i] = false;
        }

        return findAllThePermutations(nums, choice, new LinkedList<>(), new LinkedList<>());
    }

    public static void main(String[] args) {
        Question46 q = new Question46();
        List<List<Integer>> res = q.permute(new int[]{1, 2, 3});

        res.forEach(integers -> System.out.println(integers));

    }

}
