package info.ds.binary_search;

import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int max = Integer.MIN_VALUE; //nlog(n)
        //n
        for(int s : stalls ){
            max = Math.max(max,s);
        }
        int low = 1;
        int high = max;
        int ans = -1;
        //logn
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(stalls, mid, k)){
                low=mid+1;
                ans = mid;
            }
            else{
                high = mid-1;
            }
        }

        return high;
    }

    private static Boolean isPossible(int[] stalls, int d,int cow){

        int lastPlaced = -1; //last index where cow was placed.
        for(int i = 0;i<stalls.length;i++){
            if(lastPlaced==-1 || (stalls[i]-stalls[lastPlaced]>=d)){
                lastPlaced = i;
                cow--;
                if(cow==0) return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
