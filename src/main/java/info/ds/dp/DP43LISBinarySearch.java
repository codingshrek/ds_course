package info.ds.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DP43LISBinarySearch {

    public static int longestIncreasingSubsequence(int arr[]) {
        List<Integer> temp = new LinkedList<>();
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(i>0){
                replace(temp,arr[i]);
            }
            else{
                temp.add(arr[i]);
            }
        }


        return temp.size();
    }

    private static void replace(List<Integer> temp,Integer key){
        int pos = Collections.binarySearch(temp,key);
        if(pos<0) pos=(pos*-1)-1;

        if(pos>temp.size()-1){
            temp.add(key);
        }
        else {
            temp.set(pos,key);
        }
    }

    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{5,7,8,5}));
    }

}
