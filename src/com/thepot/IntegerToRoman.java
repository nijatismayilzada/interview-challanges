package com.thepot;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    private static final Map<Integer, Character> romanMap = new TreeMap<>();

    static {
        romanMap.put(1000, 'M');
        romanMap.put(500, 'D');
        romanMap.put(100, 'C');
        romanMap.put(50, 'L');
        romanMap.put(10, 'X');
        romanMap.put(5, 'V');
        romanMap.put(1, 'I');
    }

    public static void main(String[] args) {
        // write your code here
    }

    public String intToRoman(int num) {

        for(int i = 0; i<romanMap.size(); i++){

        }

        return "";
    }
}
