package com.thepot;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("\\W+");
        Map<String, Integer> paragraphMap = new HashMap<>();

        for (String word : words) {
            Integer count = paragraphMap.get(word);
            if (count == null) {
                paragraphMap.put(word, 1);
            } else {
                count++;
                paragraphMap.put(word, count);
            }
        }

        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        int max = 0;
        String returnWord="";
        for(Map.Entry<String, Integer> entry : paragraphMap.entrySet()){
            if(entry.getValue()>max && !ban.contains(entry.getKey())){
                max = entry.getValue();
                returnWord = entry.getKey();
            }
        }
        return returnWord;

    }
}
