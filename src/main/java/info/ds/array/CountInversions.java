package info.ds.array;

import java.util.ArrayList;
import java.util.List;

public class CountInversions {

    private static int merge(int l, int mid,int r, int[] arr){

        List<Integer> temp = new ArrayList<>();
        int i = l;
        int j = mid+1;
        int c =0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;

            }
            else{

                temp.add(arr[j]);
                c+=(mid-i+1);
                j++;

            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=r){
            temp.add(arr[j]);
            j++;
        }

        for(i = l;i<=r;i++){
            arr[i] = temp.get(i-l);
        }

        return c;

    }
    private static int  mergeSort(int l , int r , int[] arr){

        int c = 0;
        if(l>=r) return c;
        int mid = (l+r)/2;
        c += mergeSort(l, mid, arr);
        c += mergeSort(mid+1, r, arr);
        c += merge(l, mid, r, arr);

        return c;

    }

    public static int numberOfInversions(int []a, int n) {
        return mergeSort(0, n-1, a);
    }
}
