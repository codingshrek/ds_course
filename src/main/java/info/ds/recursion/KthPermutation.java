package info.ds.recursion;

import java.util.LinkedList;
import java.util.List;

public class KthPermutation {

    public List<Integer> solve(int k, List<Integer> nums, List<Integer> res) {
        if (nums.size() == 0) {
            return res;
        }
        if (nums.size() == 1) {
            res.add(nums.get(0));
            return res;
        }

        int permutations = fact(nums.size() - 1);
        int curNumPos = k / permutations;
        res.add(nums.get(curNumPos));
        nums.remove(curNumPos);
        int skipped = permutations * curNumPos;
        k = k - skipped;

        solve(k, nums, res);

        return res;


    }

    public List<Integer> kthPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        return solve(k - 1, nums, res); // since we are using 0 based indexing we need to find the kth permuatation.
    }

    public int fact(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        KthPermutation p = new KthPermutation();
        System.out.println(p.kthPermutation(4, 17));
    }
}
