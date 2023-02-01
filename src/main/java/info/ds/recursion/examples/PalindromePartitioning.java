package info.ds.recursion.examples;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {


    public List<List<String>> solution(int index, String s, List<String> ds, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(ds));
            return result;
        }
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i+1);
            if (isPalindrome(substring)) {
                ds.add(substring);
                solution(i+1, s, ds, result);
                ds.remove(ds.size()-1);
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!(s.charAt(i) == s.charAt(j))) {
                return false;

            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {

        PalindromePartitioning p = new PalindromePartitioning();
        p.solution(0,"aabb",new ArrayList<>(),new ArrayList<>());

    }
}
