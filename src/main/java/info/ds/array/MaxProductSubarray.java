package info.ds.array;

public class MaxProductSubarray {

    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        int i = 0;

        while(i<n){
            if(arr[i]==0){
                prefix =1;
                i++;
            }
            else{
                prefix = prefix * arr[i];
                max = Math.max(max, prefix);
                i++;
            }

        }

        i =n-1;
        while(i>=0){
            if(arr[i]==0){
                suffix =1;
                i--;
            }
            else{
                suffix = suffix * arr[i];
                max = Math.max(max, suffix);
                i--;
            }

        }

        return max;
    }
}
