package com.thepot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] intervalP = intervals[0];

        List<int[]> intervalsF = new ArrayList<>();


        for (int[] interval : intervals) {
            if (intervalP[1] >= interval[0]) {
                intervalP[1] = Math.max(intervalP[1], interval[1]);
            } else {
                intervalsF.add(intervalP);
                intervalP = interval;
            }
        }
        intervalsF.add(intervalP);

        return intervalsF.toArray(new int[][]{});


    }

}
