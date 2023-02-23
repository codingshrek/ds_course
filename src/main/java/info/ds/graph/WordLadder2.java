package info.ds.graph;

import java.lang.reflect.Array;
import java.util.*;

public class WordLadder2 {

    private void findWords(String startWord, Set<String> wordSet, ArrayList<String> tempList, Queue<ArrayList<String>> q, List<String> usedOnLevel) {


        for (int j = 0; j < startWord.length(); j++) {
            for (char i = 'a'; i <= 'z'; i++) {
                char[] charArray = startWord.toCharArray();
                charArray[j] = i;
                String wordToFind = new String(charArray);
                if (wordSet.contains(wordToFind)) {
                    ArrayList<String> wordList = new ArrayList<>(tempList);
                    wordList.add(wordToFind);
                    q.offer(wordList);
                    usedOnLevel.add(wordToFind);
                }
            }
        }
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {

            wordSet.add(wordList[i]);
        }

        ArrayList<String> queueList = new ArrayList<>();
        queueList.add(startWord);
        q.offer(queueList);
        int level = 0;

        ArrayList<String> usedOnLevel = new ArrayList<>();

        while (!q.isEmpty()) {

            ArrayList<String> tempList = q.poll();
            String lastWord = tempList.get(tempList.size() - 1);
            if (result.size() > 0 && tempList.size() > result.get(0).size()) break;
            if (lastWord.equals(targetWord)) {
                result.add(tempList);

            } else {
                if (tempList.size() > level) {
                    level++;
                    wordSet.removeAll(usedOnLevel);
                    usedOnLevel = new ArrayList<>();
                }
                findWords(lastWord, wordSet, tempList, q, usedOnLevel);
            }
        }

        return result;

    }
}
