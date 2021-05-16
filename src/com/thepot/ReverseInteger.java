package com.thepot;

public class ReverseInteger {


    public int reverse(int x) {

        String number = String.valueOf(x);

        char[] chars = number.toCharArray();

        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {

            if (chars[i] != '-') {
                reversed = reversed.concat(String.valueOf(chars[i]));
            } else {
                reversed = String.valueOf(chars[i]).concat(reversed);
            }


        }
        try {

            return Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }


    }


}
