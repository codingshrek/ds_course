package info.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List< List < Integer > > triplet(int t, int []arr) {

        int n = arr.length;
        int target = 0;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int j=i+1;
            int k = n-1;
            while(j<n && j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum == target){
                    ans.add(Arrays.asList(arr[i],arr[j],arr[k]));
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1])j++;
                    while(k>j && arr[k]==arr[k+1])k--;
                }
                else if(sum<target)j++;
                else if(sum>target)k--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSum.triplet(5,new int[]{-1,-1,2,0,1}).stream().forEach(i-> System.out.println(i));
    }
}
