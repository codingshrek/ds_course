package info.ds.recursion.examples;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationOfStringArray {

    public static void solution(String input, List<Character> ds, boolean temp[]) {

        if (ds.size() == input.length()) {
            System.out.println(ds);
            return;
        }

        for (int i = 0; i <= input.length() - 1; i++) {

            if (temp[i] == false) {
                ds.add(input.charAt(i));
                temp[i] = true;
                solution(input, ds, temp);

                ds.remove(ds.size() - 1);
                temp[i] = false;
            }
        }

    }

    /**
     * This solution does not use extra temp array.
     */
    public static void solution(int index, int input[]) {

        if(index==input.length){
            Arrays.stream(input).forEach(i-> System.out.print(i));
            System.out.println();
            return;
        }

        for(int i=index;i<input.length;i++){
            swap(input,i,index);
            solution(index+1,input);
            input= swap(input,i,index);
        }


    }

    public static int[] swap(int input[], int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;

        return input;
    }

    public static void main(String[] args) {
        String input = "abc";
        boolean temp[] = new boolean[input.length()];
        for (int i = 0; i < input.length() - 1; i++) {
            temp[i] = false;
        }

        //solution(input, new LinkedList<Character>(), temp);

        solution(0,new int[]{1,2,3});

    }

}
