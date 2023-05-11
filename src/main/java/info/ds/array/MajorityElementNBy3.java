package info.ds.array;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementNBy3 {

    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;
        int e1=Integer.MIN_VALUE;
        int e2=Integer.MIN_VALUE;
        int c1=0;
        int c2=0;

        for(int i=0;i<n;i++){
            int cur = nums[i];
            if(c1==0 && cur!=e2){
                e1=cur;
                c1=1;
            }
            else if(c2==0 && cur!=e1){
                e2=cur;
                c2=1;
            }
            else if(cur==e1) c1++;
            else if(cur==e2) c2++;
            else{
                c1--;
                c2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int maj = (int)Math.floor(n/3);
        c1=0;c2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==e1)c1++;
            if(nums[i]==e2)c2++;
        }
        if(c1>maj) ans.add(e1);
        if(c2>maj) ans.add(e2);
        Collections.sort(ans);
        return ans;
    }

}
