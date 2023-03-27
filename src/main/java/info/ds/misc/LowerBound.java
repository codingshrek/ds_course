package info.ds.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LowerBound {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,8,11,16,18,21);
        System.out.println(Collections.binarySearch(new ArrayList<Integer>(arr),12));



    }
}
