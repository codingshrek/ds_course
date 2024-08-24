package info.ds.array;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static String minSubString(String s, String t) {
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int dc = initMapAndReturnDC(t, map);
        String ans = "";
        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                int tp = map.get(c);
                tp--;
                if (tp==0) dc--;
                map.put(c, tp);
            }
            if (dc > 0) {
                j++;
            } else if (dc == 0) {
                //Reducing window size and finding answers. Note : Window size cannot be less than size of t. therefore j-i+1>t.length()
                while (dc == 0 && (j-i+1)>t.length()) {
                    if(dc==0 && ((ans.length()==0)||ans.length()>(j-i+1))) ans = s.substring(i,j+1);
                    char tempChar = s.charAt(i);
                    if (map.containsKey(tempChar)) {
                        int temp = map.get(tempChar);
                        temp++;
                        if (temp == 1) dc++;
                        map.put(tempChar,temp);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }

    /**
     * Initializes map and return distinct char count.
     */
    private static int initMapAndReturnDC(String t, Map<Character, Integer> map) {
        int c = 0;
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int cur = map.get(t.charAt(i));
                cur++;
                map.put(t.charAt(i), cur);
            } else {
                c++;
                map.put(t.charAt(i), 1);
            }
        }
        return c;
    }

}

