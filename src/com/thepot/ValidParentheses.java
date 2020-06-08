package com.thepot;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {

        Stack<Integer> stack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && canClose(charArray[stack.peek()], c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    private static boolean canClose(char c1, char c2) {
        return (c1 == '(' && c2 == ')') ||
                (c1 == '[' && c2 == ']') ||
                (c1 == '{' && c2 == '}');
    }
}
