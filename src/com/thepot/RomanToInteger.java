package com.thepot;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);
    }

    public int romanToInt(String s) {

        char[] input = s.toCharArray();

        int value = 0;

        int previous = 0;

        for (char c : input) {

            int currval = romanMap.get(c);

            if (previous != 0 && previous < currval) {
                value = value  - previous + (currval - previous);
            } else {
                value += currval;
            }

            previous = currval;


        }

        return value;


    }

}
