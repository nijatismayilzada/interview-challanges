package com.thepot;

import java.util.*;

public class WordLadderII {


    public static void main(String[] args) {

        System.out.println(new WordLadderII().findLadders("red", "tax", Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")));


    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<String> wordListTotal = new ArrayList<>();
        wordListTotal.add(beginWord);
        wordListTotal.addAll(wordList);

        Map<String, Wordg> graph = new HashMap<>();

        for (String word : wordListTotal) {
            graph.put(word, new Wordg(word));
        }


        for (int bg = 0; bg < wordListTotal.size(); bg++) {

            String bgW = wordListTotal.get(bg);
            Set<Character> bgS = toCharSet(bgW.toCharArray());


            for (int eg = bg + 1; eg < wordListTotal.size(); eg++) {

                String egW = wordListTotal.get(eg);
                Set<Character> egS = toCharSet(egW.toCharArray());
                egS.removeAll(bgS);

                if (egS.size() == 1) {
                    graph.get(bgW).edges.add(graph.get(egW));
                    graph.get(egW).edges.add(graph.get(bgW));
                }
            }
        }


        Set<List<String>> result = new HashSet<>();
        Queue<List<String>> buffer = new LinkedList<>();


        int shortest = Integer.MAX_VALUE;


        buffer.add(Arrays.asList(graph.get(beginWord).word));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);


        while (!buffer.isEmpty()) {

            List<String> path = buffer.poll();

            String lastW = path.get(path.size() - 1);

            List<Wordg> neighbors = graph.get(lastW).edges;

            for (Wordg neighbor : neighbors) {
                if (!visited.contains(neighbor.word)) {

                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor.word);


                    if (neighbor.word.equals(endWord)) {
                        if (newPath.size() < shortest) {
                            result.clear();
                            result.add(newPath);
                            shortest = newPath.size();
                        } else if (newPath.size() == shortest) {
                            result.add(newPath);
                        }
                    } else {
                        visited.add(neighbor.word);
                        buffer.offer(newPath);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    private Set<Character> toCharSet(char[] word) {
        Set<Character> newSet = new HashSet<>();

        for (char c : word) {
            newSet.add(c);
        }
        return newSet;


    }


}

class Wordg {
    String word;
    List<Wordg> edges;

    public Wordg(String word) {
        this.word = word;
        this.edges = new ArrayList<>();
    }
}