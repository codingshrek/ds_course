package info.ds.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question78 {

    public List<List<Integer>> solution(int index, List<Integer> ds, List<List<Integer>> result, int nums[]) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(ds));
            return result;
        }

        //Pick
        Integer ch = nums[index];
        ds.add(ch);
        solution(index + 1, ds, result, nums);
        ds.remove(ds.size() - 1);

        //Not pick
        solution(index + 1, ds, result, nums);


        return result;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> solutions = solution(0, new LinkedList<>(), new ArrayList<>(), nums);
        return solutions;
    }

    public static void main(String[] args) {
        Question78 q = new Question78();
        q.subsets(new int[]{1, 2, 3, 4});
    }
}
