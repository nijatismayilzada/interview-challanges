package com.thepot;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("bba", "ba"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();

        for (char tChar : t.toCharArray()) {
            Integer count = tMap.get(tChar);

            if (count == null) {
                tMap.put(tChar, 1);
            } else {
                tMap.put(tChar, ++count);
            }
        }

        char[] sArr = s.toCharArray();
        int l = -1;
        int r = -1;

        boolean forward = true;
        String minimumWindow = "";

        while ((!forward && (l < s.length())) || (forward && (r < s.length() - 1))) {
            if (forward) {
                r++;
                Integer count = tMap.get(sArr[r]);
                if (count != null) {
                    if (l == -1) {
                        l = r;
                    }
                    count--;
                    tMap.put(sArr[r], count);
                    if (foundAll(tMap)) {
                        minimumWindow = getString(s, l, r, minimumWindow);
                        forward = false;
                    }
                }

            } else {
                Integer count = tMap.get(sArr[l]);
                if (count != null) {
                    if (!foundAll(tMap)) {
                        forward = true;
                        l--;
                    } else {
                        count++;
                        tMap.put(sArr[l], count);
                        minimumWindow = getString(s, l, r, minimumWindow);
                    }
                }
                l++;
            }
        }
        return minimumWindow;
    }

    private String getString(String s, int l, int r, String minimumWindow) {
        String substring = s.substring(Math.max(l, 0), r + 1);
        if (minimumWindow.equals("") || (minimumWindow.length() > r - l)) {
            return substring;
        }
        return minimumWindow;
    }

    private boolean foundAll(Map<Character, Integer> tMap) {
        for (Integer i : tMap.values()) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}
