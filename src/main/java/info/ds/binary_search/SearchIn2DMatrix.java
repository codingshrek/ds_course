package info.ds.binary_search;

import java.util.ArrayList;

public class SearchIn2DMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {

        boolean ans =  false;

        int low = 0 ;
        int n = mat.size();
        int m = mat.get(0).size();
        int high = mat.size()*mat.get(0).size()-1;

        while(low<=high){
            int mid = (low+high)/2;
            int r = mid/m;
            int c = mid%m;
            int num =mat.get(r).get(c);
            if(num==target)return true;
            if(target > num) low = mid+1;
            else high = mid-1;
        }

        return ans;

    }
}
