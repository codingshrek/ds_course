package info.ds.recursion.examples;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {


    static Map<Integer, Integer> cache = new HashMap<>();

    private static int findTheTotalNumber(int height, int n) {

        if (height == 0) {
            return 1;
        }
        if (height == 1) {
            return 1;
        }


        if (cache.containsKey(height)) {
            return cache.get(height);
        }

        int leftRecursion = findTheTotalNumber(height - 1, n);

        int rightRecursion = findTheTotalNumber(height - 2, n);

        int sol = leftRecursion + rightRecursion;

        cache.put(height, sol);
        return sol;
    }

    public static int climbStairs(int n) {
        return findTheTotalNumber(n, n);
    }

    public static void main(String[] args) {
        System.out.println(ClimbingStairs.climbStairs(2));
    }
}
