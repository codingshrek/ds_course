package info.ds.leetcode;

public class Question3 {

    static int count = 0;

    public static int lengthOfLongestSubstring(String s) {

        int length = 0;
        String buffer = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            if (buffer.length() > length) {
                length = buffer.length();
            }
            buffer = "";
            for (int j = i; j <= s.length() - 1; j++) {
                String ch = String.valueOf(s.charAt(j));
                if (!buffer.contains(ch)) {
                    buffer = buffer + ch;

                } else {
                    break;
                }
            }
        }

        return length;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("a");
    }

}
