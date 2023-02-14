package info.ds.array_string.sliding_window;

import java.util.Arrays;
import java.util.List;

public class MaxSumSubArray {

   /* static long maximumSumSubArray(int K, List<Integer> Arr, int N) {
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        sum = max;        //initialize window

        while (j < N) {
            sum += Arr.get(j);
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                max = Math.max(max, sum);
                sum = sum - Arr.get(i);
                j++;
                i++;
            }
        }

        return max;
    }*/
 static long maximumSumSubArray(int K, List<Integer> Arr, int N) {
        int i = 0;
        int j = 0;
        int max = 0;
        int sum = 0;
        sum = max;        //initialize window


       while(j<K){
           sum = sum+Arr.get(j);
           j++;
       }
       max = sum;

      while(j<=N-1){

          sum = sum+Arr.get(j)-Arr.get(i);
          max = Math.max(sum,max);
          i++;
          j++;

      }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(MaxSumSubArray.maximumSumSubArray(3, Arrays.asList(100, 900, 800, 900,700,100,200), 7));
        ;
    }

}
