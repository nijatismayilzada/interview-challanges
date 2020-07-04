package com.thepot;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {

        char[] v1 = version1.toCharArray();
        char[] v2 = version2.toCharArray();

        int maxI = Math.max(v1.length, v2.length);

        int i1 = 0;
        int i2 = 0;

        StringBuilder s1 = new StringBuilder();
        boolean b1 = false;
        StringBuilder s2 = new StringBuilder();
        boolean b2 = false;

        while (true) {
            if (i1 < v1.length && v1[i1] != '.') {
                s1.append(v1[i1]);
                i1++;
            } else {
                b1 = true;
            }


            if (i2 < v2.length && v2[i2] != '.') {
                s2.append(v2[i2]);
                i2++;
            } else {
                b2 = true;
            }


            if (b1 && b2) {
                if (s1.length() == 0) {
                    s1.append('0');
                }

                if (s2.length() == 0) {
                    s2.append('0');
                }

                int ver1 = Integer.parseInt(s1.toString());
                int ver2 = Integer.parseInt(s2.toString());

                if (ver1 > ver2) {
                    return 1;
                } else if (ver1 < ver2) {
                    return -1;
                } else {
                    i1++;
                    i2++;

                    if (i1 >= maxI && i2 >= maxI) {
                        return 0;
                    }

                    b1 = false;
                    b2 = false;
                    s1.setLength(0);
                    s2.setLength(0);
                }
            }
        }
    }
}
