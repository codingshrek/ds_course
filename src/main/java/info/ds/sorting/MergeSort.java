package info.ds.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;

        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);

    }

    private static void merge(int[] arr,int low,int mid,int high){
        List<Integer> temp = new ArrayList<>();

        int l = low;
        int r = mid+1;

        while(l<=mid && r<=high){
            if(arr[l]>arr[r]){
                temp.add(arr[r]);
                r++;
            }
            else{
                temp.add(arr[l]);
                l++;
            }
        }

        while(l<=mid){
            temp.add(arr[l++]);
        }
        while(r<=high){
            temp.add(arr[r++]);
        }
        for(int i=low;i<=high;i++){
            arr[i]  = temp.get(i - low);
        }


    }
}
