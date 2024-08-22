package info.ds.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctChars {

    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int c = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        while (j < n) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
                c++;
            }
            if (c < k) {
                j++;
            } else if (c == k) {
                max = Math.max(j - i + 1, max);
                j++;
            } else if (c > k) {
                while (c > k) {
                    char temp = s.charAt(i);
                    int tempC = map.get(temp);
                    tempC--;
                    if (tempC == 0) {
                        c--;
                        map.remove(temp);
                    }
                    else{
                        map.put(temp,tempC);
                    }
                    i++;
                }
                j++;
            }
        }
        return max!=0?max:-1;
    }
}
