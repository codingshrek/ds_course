package info.ds.leetcode;

/**
 * Longest palindromic substring
 * Need to implement optimal solution.
 */
public class Question5 {

    private boolean isPalindrome(String test) {
        if(test.length()==1) return true;
        if(test.length()==0) return false;
        int i = 0;
        int j = test.length() - 1;
        while (i <= j) {
            if (test.charAt(i) != test.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome(String s) {

        String longestPalindrome="";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String temp = s.substring(i,j);
                if(isPalindrome(temp) && longestPalindrome.length()<temp.length()){
                    longestPalindrome = temp;
                }
            }
        }
        return longestPalindrome;
    }
    
    public static void main(String[] args) {
        Question5 q = new Question5();
        System.out.println(q.longestPalindrome("cbbd"));;
    }

}
