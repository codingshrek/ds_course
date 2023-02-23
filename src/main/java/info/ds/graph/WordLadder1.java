package info.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {

    public static class Pair{

        public String word;
        public int level;

        public Pair(String word,int level){
            this.word=word;
            this.level=level;
        }

    }

    //Striver's solution is to replace every char at index i of the word from 'a' - 'z'
    //His TC -> wordlength * N * 26 where as my TC -> n^2 * m
    //His solution :
    private Set<String> findWordsWithDiff(String startWord, Set<String> words, int diff){
        Set<String> wordsDiff = new HashSet<>();
        for(String tempWord : words){
            int c = 0;

            for(int i=0;i<startWord.length();i++){

                if(startWord.charAt(i)!=tempWord.charAt(i)) c++;
            }
            if(c==diff) wordsDiff.add(tempWord);
        }
        words.removeAll(wordsDiff);
        return wordsDiff;
    }

    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {


        Queue<Pair> q = new LinkedList<>();
        Set<String> wordsSet = new HashSet<>();

        for(int i=0;i<wordList.length;i++){
            wordsSet.add(wordList[i]);
        }
        q.offer(new Pair(startWord,0));


        while(!q.isEmpty()){

            Pair p = q.poll();
            String word = p.word;
            int level = p.level;
            if(word.equals(targetWord)) return level+1;

            Set<String> diffWords = findWordsWithDiff(word,wordsSet,1);
            for(String newWord : diffWords){
                q.offer(new Pair(newWord,level+1));
            }

        }
        return 0;
    }

}
