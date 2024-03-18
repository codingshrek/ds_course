package info.ds.bs;

public class UpperBound {
    public static int upperBound(int []arr, int x, int n){

        int low = 0 ;
        int high = n-1;

        int ans = n;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
                ans = mid;
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;

    }

}