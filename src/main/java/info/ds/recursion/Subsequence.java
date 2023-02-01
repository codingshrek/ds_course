package info.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsequence {

    static List<String> list = Arrays.asList("3", "1", "2");

    /**
     * Logic :  There are two options
     * 1> To take a char at i in the subsequence.
     * 2> NOT to take char at i in the subsequence.
     */
    public static void subsequence(int index, List<String> subsequence) {

        if (index >= list.size()) {
            System.out.println(subsequence);
            return;
        }

        String ch = list.get(index);
        //Option 1 :  To take the char at index in the subsequence
        subsequence.add(ch);
        subsequence(index + 1, subsequence);
        //Option 2: No to take the char at index in the subsequence
        subsequence.remove(ch);
        subsequence(index + 1, subsequence);

    }


    static List<Integer> intList = Arrays.asList(1, 2, 1);

    /**
     * Logic :  Same as subsequence , we just need to check if sum = sum(subsequence);
     */
    public static void findAllTheSubsequenceWhichEqualsToSum(int index, List<Integer> subsequence, int sum) {


        if (index >= intList.size()) {
            int ts = 0;
            for (Integer t : subsequence) {
                ts = ts + t;
            }
            if (ts == sum) {
                System.out.println(subsequence);
            }
            return;
        }

        Integer ch = intList.get(index);
        //Option 1 :  To take the char at index in the subsequence
        subsequence.add(ch);
        findAllTheSubsequenceWhichEqualsToSum(index + 1, subsequence, sum);
        //Option 2: No to take the char at index in the subsequence
        subsequence.remove(ch);
        findAllTheSubsequenceWhichEqualsToSum(index + 1, subsequence, sum);

    }

    /*
      Print only one subsequence where sum(subsequence[i]) equals sum.
      WIP : TO implement
     */

    /**
     * In case of counting subsequences. Follow the following pattern
     * THis is just a pattern not a complete code
     */
    public static int countSubsequences(int index, int arr[]) {
        boolean condition = false;
        boolean reachedBaseCase = true;
        if (reachedBaseCase) {
            if (condition == true) {
                return 1;
            } else {
                return 0;
            }
        }
        int leftRecursuion = countSubsequences(index + 1, new int[]{1, 2});
        int rightRecursuion = countSubsequences(index + 1, new int[]{1, 2});

        return leftRecursuion + rightRecursuion;
    }


    static List<Integer> intList2 = Arrays.asList(2, 3, 6, 7);

    /**
     * TUF Lecture 8
     */
    public static void findAllTheCombinationWhichSumsToSum(int index, int sum, List<Integer> combination) {

        if (index >= intList2.size()) {
            if (sum == 0) {
                System.out.println(combination);
            }
            return;
        }
        int ch = intList2.get(index);
        if ((sum - ch) >= 0) {
            combination.add(ch);
            findAllTheCombinationWhichSumsToSum(index, sum - ch, combination);
            //Removing element when above recursion completes so that out state remains as it was before recursion call.
            combination.remove(new Integer(ch));
        }
        findAllTheCombinationWhichSumsToSum(index + 1, sum, combination);
    }


    static List<Integer> intList3 = Arrays.asList(1, 1, 1, 2, 2);

    /**
     * TUF Lecture 9
     * [1,1,1,2,2] = all the unique combinations would be (1,1,2) and (2,2)
     * If we did not have unique constraint , then answer would be (1,1,2) ,(1,1,2) , (2,2) because first answer would be 1st and 2nd 1's and then 4th 2 .
     * Second answer is 2nd and 3rd 1's and 4th 2.
     * <p>
     * The idea here is not to pick/unpick rather idea here is to check whether we can start with all the other next element at same level.
     */
    public static void findAllTheUniqueCombinationWhichSumsToSum(int index, int sum, List<Integer> combination) {


        if (sum == 0) {
            System.out.println("SUM " + sum + " at index :" + index + " Subsequence " + combination);
            return;
        }

        for(int i = index; i<intList3.size(); i++){

            if(i>index && intList3.get(i)==intList3.get(i-1)) continue;
            if(intList3.get(i)>sum) break;

             combination.add(intList3.get(i));
             findAllTheUniqueCombinationWhichSumsToSum(i+1,sum-intList3.get(i),combination); // i+1 not index+1
             combination.remove(combination.size()-1);
        }
    }


    public static void main(String[] args) {

        subsequence(0,new ArrayList<>(3));
        //findAllTheUniqueCombinationWhichSumsToSum(0, 4, new ArrayList<>());
    }
}
