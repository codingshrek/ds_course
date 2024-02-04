package info.ds.sorting;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr,int low, int high) {

        if(low<high){
            int pIndex = partition(arr,low,high);
            quickSort(arr,low,pIndex-1);
            quickSort(arr,pIndex+1,high);
        }

    }

    private static int partition(int[] arr,int low,int high){
        int p = low;

        int i = low;
        int j = high;

        while(i<j){

            while(i<=high-1 && arr[i]<=arr[p]){
                i++;
            }
            while(j>=low+1 && arr[j]>=arr[p]){
                j--;
            }
            if(i<j)swap(arr,i,j);
        }

        swap(arr,p,j);
        return j;

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
