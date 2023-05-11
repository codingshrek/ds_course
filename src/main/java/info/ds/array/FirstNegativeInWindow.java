package info.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNegativeInWindow {


    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        long[] res = new long[N - K + 1];
        List<Long> negatives = new ArrayList<>();
        int i = 0;
        int j = 0;
        int c = 0;
        while (j < N) {
            if (A[j] < 0) negatives.add(A[j]);
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {
                if (!negatives.isEmpty()) {
                    res[c] = negatives.get(0);
                } else {
                    res[c] = 0;
                }
                if (A[i] < 0) negatives.remove(0);
                i++;
                j++;
                c++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(FirstNegativeInWindow.printFirstNegativeInteger(new long[]{12, -1, -7, 8, -15, 30, 16, 28}, 8, 3)).forEach(i-> System.out.println(i));
    }
}
