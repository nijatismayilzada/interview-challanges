package com.thepot;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

    }


    public static int trap(int[] height) {

        if (height.length == 0) {
            return 0;
        }
        char[] range = new char[height.length - 1];

        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] <= height[i + 1]) {
                range[i] = 'i';
            } else {
                range[i] = 'd';
            }
        }

        int high = -1;

        int water = 0;

        for (int i = 0; i < range.length; i++) {
            int newHigh = -1;

            if (i == 0 && range[i] == 'd') {
                newHigh = i;
            }

            if (i != 0 && range[i - 1] == 'i' && range[i] == 'd') {
                newHigh = i;
            }

            if (i == range.length - 1 && range[i] == 'i') {
                newHigh = i + 1;
            }

            if (newHigh != -1) {
                if (high == -1) {
                    high = newHigh;
                } else {
                    water = water + cal(height, high, newHigh);
                    high = newHigh;
                }
            }
        }

        return water;

    }


    private static int cal(int[] height, int high1, int high2) {
        int min = Math.min(height[high1], height[high2]);
        int water = 0;

        for (int i = high1; i < high2; i++) {
            int posWater = min - height[i];

            if (posWater > 0) {
                water += posWater;
            }
        }

        return water;
    }
}
