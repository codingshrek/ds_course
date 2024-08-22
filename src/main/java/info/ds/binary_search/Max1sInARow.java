package info.ds.binary_search;

import java.util.ArrayList;

public class Max1sInARow {

    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        int max1 = -1;
        int ansIdx =-1;
        int c= 0;
        for(ArrayList<Integer> list : matrix){
            int low = 0;
            int high = m-1;
            int last1 = -1;
            if(list.get(m-1)==0){
                c++;
                continue;
            }
            while(low<=high){
                if(list.get(0)==1){
                    last1=0;
                    break;
                }
                int mid = (low+high)/2;
                if(list.get(mid)==1){
                    last1 = mid;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            if(last1!=-1){
                int cur1 = m-last1;
                if(cur1>max1){
                    max1 = cur1;
                    ansIdx = c;
                }
            }
            c++;
        }
        return ansIdx;
    }
}
