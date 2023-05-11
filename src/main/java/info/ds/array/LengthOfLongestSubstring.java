package info.ds.array;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            } else {
                char duplicate = s.charAt(j);
                while (set.contains(duplicate)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
            }
            j++;

        }
        return max;
    }

    public static void main(String[] args) {


        LengthOfLongestSubstring longest = new LengthOfLongestSubstring();
        System.out.println(longest.lengthOfLongestSubstring("abcaaaabcd"));

    }

}
