package info.ds.bs;

/**
 * Basically asking for lowerbound.
 */
public class InsertPosition {
    private static int lowerBound(int[] arr,int k){
        int low = 0;
        int high=arr.length-1;
        int lb = arr.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=k){
                lb=mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return lb;

    }
    public static int searchInsert(int [] arr, int m){
        return lowerBound(arr, m);
    }
}
