package info.ds.recursion.examples;

import java.util.LinkedList;
import java.util.List;

/**
 * Think at every recursion level , you are generating a unique subset
 * https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
 */
public class SubSetSum2 {


    public static void subsetSum(int index, int input[],List<Integer> ds){

        //At level 0 , empty list will be printed , at level 1 , all the subsets of size one will be printed and so on.
        System.out.println(ds);
        for(int i=index;i<=input.length-1;i++){

            if(i>index && input[i-1]==input[i]) continue;

            ds.add(input[i]);

            subsetSum(i+1,input,ds);

            ds.remove(ds.size()-1);

        }

    }

    public static void main(String[] args) {
        subsetSum(0,new int[]{1,1,2},new LinkedList<>());
    }

}
