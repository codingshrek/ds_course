package info.ds.dp;

import java.util.Arrays;
import java.util.Stack;

public class DP42PrintLIS {

    public static void printLis(int n , int[] arr){

        int[] dp = new int[n];
        int[] bt = new int[n]; // to back track

        for(int i =0;i<n;i++){
            dp[i]=1;
            bt[i]=i;
        }
        //Calculating dp and bt
        for(int i = 0;i<n;i++){
            for(int prev =0;prev<=i;prev++){
                if(arr[prev]<arr[i]){
                    if(dp[i]<dp[prev]+1){
                        dp[i]=dp[prev]+1;
                        bt[i]=prev;
                    }
                }
            }
        }

        Arrays.stream(dp).forEach(i-> System.out.print(i+" "));
        System.out.println();
        Arrays.stream(bt).forEach(i-> System.out.print(i+" "));
        System.out.println();
        //finding max
        int maxPtr = 0;
        for(int i=0;i<n;i++){
            if(dp[i]>dp[maxPtr]) maxPtr = i;
        }

        Stack<Integer> elements = new Stack<>();

        //Back tracking

        while(maxPtr!=bt[maxPtr]){
            elements.push(arr[maxPtr]);
            maxPtr = bt[maxPtr];
        }
        elements.push(arr[maxPtr]);

        while (!elements.isEmpty()){
            System.out.println(elements.pop());
        }

    }

    public static void main(String[] args) {
        printLis(6,new int[]{5,4,11,1,16,17});
    }
}
