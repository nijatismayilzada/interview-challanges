package com.thepot;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        if (nChars.length == 0) {
            return 0;
        }

        for (int h = 0; h < hChars.length; h++) {
            if (hChars[h] == nChars[0]) {
                if (contains(hChars, nChars, h)) {
                    return h;
                }
            }
        }

        return -1;
    }

    public boolean contains(char[] hChars, char[] nChars, int hInx) {
        int i = hInx;

        for (char c : nChars) {
            if (i >= hChars.length || c != hChars[i]) {
                return false;
            }
            i++;

        }
        return true;
    }
}
