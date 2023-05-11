package info.ds.array;

import java.util.*;

public class RepeatedDNASequence {

    public List<String> RepeatedDna(String s) {

        int n = s.length();
        int i = 0;
        int j = 10;
        List<String> dnas = new ArrayList<>();
        Map<String, Integer> map = new HashMap();
        while (j < n+1) {
            String sub = s.substring(i, j);
            if(map.containsKey(sub)) {
                if (map.get(sub) == 1) {
                    dnas.add(sub);
                }
                map.put(sub, map.get(sub) + 1);
                i++;
                j++;
            } else {
                map.put(sub, 1);
                i++;
                j++;
            }
        }
        return dnas;
    }

    public static void main(String[] args) {
        RepeatedDNASequence seq = new RepeatedDNASequence();
        System.out.println(seq.RepeatedDna("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());


    }

}
