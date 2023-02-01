package info.ds.recursion.examples;

import java.util.List;

/**
 * Print all the combinations which sums to n .
 * each element can be picked multiple times.
 * https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=8
 */
public class CombinationSum1 {

    public static void combinationSum(int index, int sum, int[] input, List<Integer> ds) {

        if (index >= input.length) {
            if (sum == 0) {
                System.out.println("result "+ds);
            }
            return;
        }


        if (sum >= input[index]) {
            ds.add(input[index]);
            combinationSum(index, sum - input[index], input, ds);
            ds.remove(ds.size() - 1);
        }

        combinationSum(index + 1, sum, input, ds);

    }

    public static void main(String[] args) {
        /*int arr[] = new int[]{2, 3, 6, 7};
        combinationSum(0, 7, arr, new LinkedList<>());*/

    }


}
