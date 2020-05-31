package com.thepot;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    private static final Map<Integer, String> romanMap = new TreeMap<>(Collections.reverseOrder());

    static {
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(119));
    }

    public static String intToRoman(int num) {

        for(Map.Entry<Integer, String> entry : romanMap.entrySet()){
            if(num / entry.getKey() > 0){
                int numLeft = num-entry.getKey();
                String roman = "";
                if(numLeft != 0){
                    roman = intToRoman(numLeft);
                }
                return entry.getValue() + roman;

            }
        }

        return "";
    }
}
