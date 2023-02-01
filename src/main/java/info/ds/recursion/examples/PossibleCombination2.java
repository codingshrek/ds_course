package info.ds.recursion.examples;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-increasing-sequences-length-k-first-n-natural-numbers/
 * Draw recursion tree to understand the logic
 */
public class PossibleCombination2 {

    public static void possibleCombination(int index, int n, int k, List<Integer> subsequence) {

        if (subsequence.size() == k) {
            System.out.println(subsequence);
            return;
        }
        if (index > n) {
            return;
        }

        subsequence.add(new Integer(index));
        possibleCombination(index + 1, n, k, subsequence);
        subsequence.remove(new Integer(index));

        possibleCombination(index + 1, n, k, subsequence);

    }

    public static void main(String[] args) {
        possibleCombination(1,5,3,new ArrayList<>());
    }
}
