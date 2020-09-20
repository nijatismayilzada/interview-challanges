package com.thepot;

public class MissingNumber {
    public int missingNumber(int[] nums) {

        int sum = 0;

        for (int i : nums) {
            sum = sum + i;
        }

        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
