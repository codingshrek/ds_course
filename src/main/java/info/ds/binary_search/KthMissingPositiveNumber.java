package info.ds.binary_search;

public class KthMissingPositiveNumber {

    public static int missingK(int[] vec, int n, int k) {

        int low = 0; int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = vec[mid]-mid-1;
            if(k>missing) low = mid+1;
            else high = mid-1;
        }
        //high will be -1 in case of [4,5,6,8,9] and k =3
        if(high!= -1){
            int missing  = vec[high]-high-1;
            int more = k-missing;
            return vec[high]+more;
        }
        return k;
    }
}
