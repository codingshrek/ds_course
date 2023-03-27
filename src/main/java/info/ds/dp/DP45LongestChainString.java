package info.ds.dp;

import java.util.Arrays;
import java.util.Comparator;

public class DP45LongestChainString {

    private static boolean isPossible(String s1 , String s2){

        if(s1.length()-s2.length()!=1) return false;
        int first = 0;
        int sec = 0;
        while(first<s1.length()){
            if(sec<s2.length() && s1.charAt(first)==s2.charAt(sec)){
                first++;
                sec++;
            }
            else{
                first++;
            }
        }
        if(first==s1.length() && sec==s2.length()) return true;
        return false;
    }
    public static int longestStrChain(int n, String[] arr) {

        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max =1;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(isPossible(arr[i], arr[prev]) && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;

                }
            }
            if(dp[i]>max) max=dp[i];
        }
        return max;
    }
}
