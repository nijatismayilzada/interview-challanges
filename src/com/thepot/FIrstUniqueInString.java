package com.thepot;

public class FIrstUniqueInString {
    public static void main(String[] input){
        System.out.println(new FIrstUniqueInString().firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        Integer[] counter = new Integer[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';

            if (counter[c] == null) {
                counter[c] = i;
            } else {
                counter[c] = -1;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';

            if (counter[c] != null && counter[c] !=-1){
                return i;
            }
        }
        return -1;
    }
}
