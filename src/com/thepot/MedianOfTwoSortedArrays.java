package com.thepot;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {


    public static void main(String[] args) {


        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 4, 5, 12, 16, 19, 21, 25, 27}, new int[]{93, 101, 181, 283, 344, 411, 432, 489, 511, 554, 556}));


    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Len = nums1.length;
        int nums2Len = nums2.length;

        if (nums1Len > nums2Len) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalMid = (nums1Len + nums2Len + 1) / 2;
        boolean averageMode = (nums1Len + nums2Len) % 2 == 0;

        int nums1Mid = 0;
        int nums2Mid = 0;

        int remainder = nums1Len;
        boolean goRight = true;

        int nums1Low, nums1High, nums2Low, nums2High;


        while (true) {

            remainder = (remainder + 1) / 2;
            if (goRight) {
                nums1Mid = nums1Mid + remainder;
                if (nums1Mid > nums1Len) {
                    nums1Mid = nums1Len;
                }
            } else {
                nums1Mid = nums1Mid - remainder;
            }

            nums2Mid = totalMid - nums1Mid;

            if (nums1Mid == 0) {
                nums1Low = Integer.MIN_VALUE;
            } else {
                nums1Low = nums1[nums1Mid - 1];
            }

            if (nums2Mid == 0) {
                nums2Low = Integer.MIN_VALUE;
            } else {
                nums2Low = nums2[nums2Mid - 1];
            }

            if (nums1Mid == nums1Len) {
                nums1High = Integer.MAX_VALUE;
            } else {
                nums1High = nums1[nums1Mid];
            }


            if (nums2Mid == nums2Len) {
                nums2High = Integer.MAX_VALUE;
            } else {
                nums2High = nums2[nums2Mid];
            }


            if (nums1High < nums2Low) {
                goRight = true;
            } else if (nums1Low > nums2High) {
                goRight = false;
            } else {
                break;
            }
        }

        if (averageMode) {
            return (Math.max(nums1Low, nums2Low) + Math.min(nums1High, nums2High)) / 2d;
        } else {
            return Math.max(nums1Low, nums2Low);
        }


    }


}
