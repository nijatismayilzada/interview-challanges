package com.thepot;

public class MinStack {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

    int value;
    int minVal;
    MinStack head;
    MinStack previous;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minVal = Integer.MAX_VALUE;
        head = this;
    }

    public void push(int x) {
        MinStack minStack = new MinStack();
        minStack.value = x;
        minStack.minVal = Math.min(x, head.minVal);
        minStack.previous = head;
        head = minStack;
    }

    public void pop() {
        head = head.previous;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.minVal;
    }

}
