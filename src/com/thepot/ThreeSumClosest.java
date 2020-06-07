package com.thepot;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int solution = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {

                int sum = nums[i] + nums[low] + nums[high];

                if (Math.abs(target - sum) < Math.abs(target - solution)) {
                    solution = sum;

                }

                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                } else {
                    return sum;
                }

            }


        }

        return solution;


    }

}
