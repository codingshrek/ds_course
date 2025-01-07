package info.java.streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//aabcccdabb -> a2b1c3d1a1b2 , Solution notworking
public class StreamApiQ1 {

    public static void main(String[] args) {
        String str = "aabbcccddda"; //a2b2c3d2a1
        String output = str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .flatMap(entry -> Stream.of(entry.getValue().toString(), entry.getKey().toString()))
                .collect(Collectors.joining());

        System.out.println(output);
    }
}
