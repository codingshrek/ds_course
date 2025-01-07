package info.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {


    public static class MaxFrequency {

        public void calcMaxFrequency() {
            List<Integer> l = List.of(1, 2, 3, 2, 2, 2, 3, 4, 5, 6, 7, 8);
            //Max Frequency
            int[] i = l.
                    stream().
                    collect(
                            Collectors.collectingAndThen(
                                    Collectors.groupingBy(Function.identity()),
                                    map -> map.entrySet().stream().map(es -> new int[]{es.getKey(), es.getValue().size()}).max((a, b) -> a[1] - b[1]).get()
                            )
                    );
            System.out.println(String.format("max frequeny of %s of number is %s : ", i[0], i[1]));
        }


    }



    public static void main(String[] args) {


        /*List<List<Integer>> lists = List.of(List.of(1, 2, 3, 4), List.of(4, 5, 6), List.of(7, 8, 9));

        //Flatmap
        List<Integer> flatmapList = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        flatmapList.stream().forEach(i -> System.out.println(i));*/




        int n =3 ;
        Map<Integer, Integer> countMap = new HashMap<>();

        List<Integer> array = List.of(1,2,3,4,5,3,4,1,6,7,7,1);
        // For each element i in the array, add it to the countMap and increment its count
        for (Integer i : array) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        // Create a max heap (priority queue) that will prioritize elements with higher counts.
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a-b);

              // Add all the unique elements in the array to the heap.
        heap.addAll(countMap.keySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n && !heap.isEmpty(); i++) {
            // Poll the highest-count element from the heap and add it to the result list.
            result.add(heap.poll());
        }

        System.out.println(result);

    }

}
