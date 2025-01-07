package info.java.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfEveryChar {

    public static void main(String[] args) {
        String input = "abbcdddaaac";

        Map<Character,Long> countMap=input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(countMap);
    }
}
