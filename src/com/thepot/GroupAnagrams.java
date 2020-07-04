package com.thepot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Character>, List<String>> map = new HashMap<>();

        for (String str : strs) {

            List<Character> list = str.chars().mapToObj(e -> (char) e).sorted().collect(Collectors.toList());

            if (!map.containsKey(list)) {
                map.put(list, new ArrayList<>());
            }
            map.get(list).add(str);

        }

        return new ArrayList<>(map.values());
    }
}
