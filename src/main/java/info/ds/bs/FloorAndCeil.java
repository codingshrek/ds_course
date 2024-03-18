package info.ds.bs;

public class FloorAndCeil {


    private static int ceil(int[] arr,int n,int k){
        int up = -1;
        int low = 0;
        int high= n-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]>=k){
                up = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return up;
    }
    private static int floor(int[] arr,int n,int k){
        int lb = -1;
        int low = 0;
        int high= n-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(arr[mid]<=k){
                lb = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return lb;
    }
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {

        int floor = floor(arr, n, x);
        int ceil = ceil(arr, n, x);
        return new int[]{floor!=-1?arr[floor]:floor,ceil!=-1?arr[ceil]:ceil};
    }
}
