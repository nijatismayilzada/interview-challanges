package com.thepot;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack {

    private final HashMap<Integer, Integer> counts;
    private final HashMap<Integer, Stack<Integer>> buckets;
    private Integer mostFrequency;

    public MaximumFrequencyStack() {
        counts = new HashMap<>();
        buckets = new HashMap<>();
        mostFrequency = 0;

    }

    public void push(int x) {

        Integer xCount = counts.getOrDefault(x, 0) + 1;
        counts.put(x, xCount);
        buckets.computeIfAbsent(xCount, k -> new Stack<>()).push(x);
        mostFrequency = Math.max(mostFrequency, xCount);
    }

    public int pop() {
        Stack<Integer> maxBucket = buckets.get(mostFrequency);
        Integer max = maxBucket.pop();
        counts.put(max, mostFrequency - 1);

        if (maxBucket.empty()) {
            mostFrequency--;
        }

        return max;
    }
}
