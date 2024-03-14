package info.ds.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class OccurrenceOfAnagrams {

    int search(String pat, String txt) {
        int i = 0;
        int j = 0;
        int k = pat.length();

        //Initializing map with all chars in pattern with its frequency.
        Map<Character, Integer> map = new HashMap<>();
        Integer counter = 0; //number of distinct counter
        Integer res = 0;
        Integer n = txt.length();
        while (j < k) {
            char ch = pat.charAt(j);
            if (map.get(ch) == null) {
                counter++;
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
            j++;
        }

        j = 0;
        SlideWindowHelper helper = new SlideWindowHelper(counter, map);
        while (j < n) {
            helper.insertChar(txt.charAt(j)); //if charAt(j) is present in txt , then map will reduce its frequency and if frequency is 0 , then counter will be decremented by 1.
            if (j - i + 1< k) {
                j++;
            } else if (j - i + 1 == k) {
                if (helper.getCounter() == 0) res++;
                helper.slideWindow(txt.charAt(i));
                i++;
                j++;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        OccurrenceOfAnagrams occ = new OccurrenceOfAnagrams();
        System.out.println(occ.search("aaba", "aabaabaa"));
    }
}

class SlideWindowHelper {

    private Map<Character, Integer> map; //holds chars in patterns and its frequency.
    private Integer counter; // holds the number of distinct chars in pat

    public SlideWindowHelper(Integer counter, Map<Character, Integer> map) {
        this.map = map;
        this.counter = counter;
    }

    public void insertChar(char c) {
        if (map.get(c) != null) {
            map.put(c, map.get(c) -1);
            if (map.get(c) == 0) counter--;
        }
    }

    public void slideWindow(char prev) {
        if (map.get(prev) != null) {
            map.put(prev, map.get(prev) + 1);
            if (map.get(prev) == 1) counter++; //If we are removing a char from window and when its count is 1 that means we have a new distinct character.
        }
    }

    public Integer getCounter() {
        return this.counter;
    }

}