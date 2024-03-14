package info.ds.array;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {
    private static int merge(int low,int mid,int high,int[] a){
        int c= 0;
        int i = mid+1;
        int left =low;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();


        //Counting Pairs
        for(int p = low;p<=mid;p++){
            while(i<=high && a[p]>2*a[i]) {
                i++;
            }
            c+=i-(mid+1);
        }

        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                temp.add(a[left]);
                left++;
            }
            else{
                temp.add(a[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(a[left++]);
        }
        while(right<=high){
            temp.add(a[right++]);
        }

        for(int k = low;k<=high;k++){
            a[k]=temp.get(k-low);
        }
        return c;

    }

    private static int mergeSort(int low,int high,int[] a){
        int c = 0;
        if(low>=high) return c;

        int mid = (low+high)/2;
        c += mergeSort(low, mid, a);
        c += mergeSort(mid+1,high,a);
        c += merge(low,mid,high,a);
        return c;

    }

    public static int team(int []skill, int n){
        return mergeSort(0,n-1,skill);
    }
}
