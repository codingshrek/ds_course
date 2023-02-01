package info.ds.recursion.examples;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=9
 */
public class CombinationSum2 {

    public static void combinationSum(int index, int sum, int input[], List<Integer> ds){

        if(sum==0){
            System.out.println(ds);
            return;
        }
        for(int i = index;i<input.length;i++){

            if(i>index && input[i]==input[i-1]) continue;
            if(input[i]>sum) break;

            ds.add(input[i]);
            combinationSum(i+1,sum-input[i],input,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static void main(String[] args) {
        combinationSum(0,4,new int[]{1,1,1,2,2},new LinkedList<>());
    }
}
