package com.thepot;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;

        for (int x = 0; x < nums.length; x++) {

            int backUpSum = 0;

            for (int y = x; y < nums.length; y++) {
                backUpSum = backUpSum + nums[y];
                if (backUpSum > max) {
                    max = backUpSum;
                }
            }
        }

        return max;

    }


    public int maxSubArrayOptimal(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

}
