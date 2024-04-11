package info.ds.binary_search;

/**
 * Idea : symmetry the merged sorted array.
 */
public class MedianOf2SortedArrays {

    public static double median(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a);

        int n = n1+n2;
        int left = (n1+n2+1) / 2;
        int low = 0; // Selecting no elements from left
        int high = n1; //Selecting all elemets;

        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;

            //Calculating left and right
            int l1 = mid1 > 0 ? a[mid1 -1] :  Integer.MIN_VALUE;
            int l2 = mid2 >0  ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1<n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2<n2 ? b[mid2] : Integer.MAX_VALUE;

            if(l1<=r2 && l2 <= r1){
                if(n%2==0) return (double) ((Math.max(l1,l2) +Math.min(r1,r2))/2.0);
                else return Math.max(l1,l2);
            }
            else if(l1> r2){
                high = mid1-1;
            }
            else low = mid1 +1;
        }

        return 0;
    }
}
