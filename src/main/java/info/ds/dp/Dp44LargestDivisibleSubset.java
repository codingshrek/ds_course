package info.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dp44LargestDivisibleSubset {

    public static ArrayList<Integer> divisibleSet(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);

        int[] dp = new int[n];
        int[] bt = new int[n];

        for(int i=0;i<n;i++){
            bt[i]=i;
        }

        for(int i =0;i<n;i++){
            dp[i]=1;
            for(int prev = 0;prev<i;prev++){
                if(arr[i]%arr[prev]==0 && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    bt[i]=prev;
                }
            }

        }

        int maxPtr = 0;
        for(int i=0;i<n;i++){
            if(dp[i]>dp[maxPtr]) maxPtr = i;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(maxPtr!=bt[maxPtr]){
            ans.add(arr[maxPtr]);
            maxPtr = bt[maxPtr];
        }
        ans.add(arr[maxPtr]);
        Collections.reverse(ans);
        return ans;
    }

}
