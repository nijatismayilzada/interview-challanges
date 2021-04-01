package com.thepot;

import java.util.*;

public class WordBreak {


    public static void main(String[] args){

        System.out.println(new WordBreak().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat", "an")));


    }


    public boolean wordBreak(String s, List<String> wordDict) {

        TreeSet<String> words = new TreeSet<>(Comparator.comparing(String::length).thenComparing(String::compareTo));
        words.addAll(wordDict);
        Boolean[] canBreak = new Boolean[s.length()];
        return wordBreakHelper(s, words, 0, canBreak);

    }

    private boolean wordBreakHelper(String s, TreeSet<String> words, int startIdx, Boolean[] canBreak) {


        if (s.equals("")) {
            return true;
        }

        if (canBreak[startIdx] != null) return canBreak[startIdx];

        for (int i = 1; i <= s.length(); i++) {

            if(i<words.first().length()){
            } else if (words.first().length() <= i && i <= words.last().length()) {

                String t = s.substring(0, i);

                if (words.contains(t)) {
                    if (wordBreakHelper(s.substring(i), words, startIdx+i, canBreak)) {
                        canBreak[startIdx] = true;
                        return true;
                    }
                }

            } else {
                canBreak[startIdx] = false;
                return false;
            }

        }

        canBreak[startIdx] = false;
        return false;
    }
}
