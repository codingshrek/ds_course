package info.ds.leetcode;

public class Question115 {

    int ways = 0;

    public int solution(int index, String temp, String s, String t) {

        if (index >= s.length()) {

            if (temp.equalsIgnoreCase(t)) {
                ways = ways + 1;
            }
            return ways;
        }

        String ch = String.valueOf(s.charAt(index));
        temp = temp + ch;
        solution(index + 1, temp, s, t);
        temp = temp.substring(0, temp.length() - 1);


        solution(index + 1, temp, s, t);

        return ways;

    }

    public int numDistinct(String s, String t) {
        return solution(0, "", s, t);
    }


    public static void main(String[] args) {
        Question115 q = new Question115();
        System.out.println(q.numDistinct("rabbbit", "rabbit"));

    }
}
