package info.ds.recursion.examples;

import java.util.*;

/**
 * Pick , Not Pick Logic
 * https://www.youtube.com/watch?v=rYkfBRtMJr8&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=10
 */
public class SubSetSum1 {

    public static void subset(int index, int sum, List<Integer> input, Collection<Integer> ds){
        if(index>=input.size()){
            System.out.println("Subset "+ds+" SUM "+sum);
            return;
        }

        Integer ch = new Integer(input.get(index));
        ds.add(ch);
        subset(index+1,sum+ch,input,ds);
        ds.remove(ch);

        subset(index+1,sum,input,ds);

    }

    public static void main(String[] args) {
        subset(0,0, Arrays.asList(3,1,2),new TreeSet<>());
    }

}
