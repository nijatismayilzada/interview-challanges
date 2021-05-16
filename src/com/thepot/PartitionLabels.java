package com.thepot;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] chars = s.toCharArray();

        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[chars[i] - 'a'] = i;
        }

        int last = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, map[chars[i] - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

}
