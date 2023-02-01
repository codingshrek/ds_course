package info.ds.recursion.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Print all the combinations of length r in a given array.
 * https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
 */
public class PossibleCombination {


    private static void printAllCombination(int index, List<Integer> combination,List<Integer> input) {

        if(index>=input.size()){
            if(combination.size()==2){
                System.out.println(combination);
            }
            return;
        }

        Integer ch = new Integer(input.get(index));
        combination.add(ch);
        printAllCombination(index+1,combination,input);
        combination.remove(ch);

        printAllCombination(index+1,combination,input);

    }

    public static void main(String[] args) {
        printAllCombination(0,new LinkedList<>(), Arrays.asList(1, 2, 3, 4));
    }
}
