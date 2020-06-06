package com.thepot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> solution = new ArrayList<>();


        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {

                if (nums[low] > -nums[i] || nums[high] > -nums[i]) {
                    break;
                }

                if (nums[low] + nums[high] == -nums[i]) {
                    solution.add(Arrays.asList(nums[i], nums[low], nums[high]));


                    do {
                        low++;
                    } while (nums[low] == nums[low - 1] && low < high);

                    do {
                        high--;
                    } while (nums[high] == nums[high + 1] && high > low);
                } else if (nums[low] + nums[high] < -nums[i]) low++;
                else {
                    high--;
                }

            }


        }

        return solution;


    }

}
