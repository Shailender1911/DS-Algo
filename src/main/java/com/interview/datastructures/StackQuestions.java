package com.interview.datastructures;

import java.util.*;

/**
 * Stack Data Structure Interview Questions
 * 
 * This class contains top 10 most important stack manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 * 
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class StackQuestions {
    
    /**
     * 1. Valid Parentheses
     * 
     * Problem: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack
     */
    public boolean isValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        
        for (char c : s.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    /**
     * 2. Min Stack
     * 
     * Problem: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
     * 
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(n) where n is the number of elements
     */
    public static class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        
        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }
        
        public void pop() {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(minStack.peek())) {
                    minStack.pop();
                }
                stack.pop();
            }
        }
        
        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }
        
        public int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }
    
    /**
     * 3. Evaluate Reverse Polish Notation
     * 
     * Problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * 
     * Time Complexity: O(n) where n is the number of tokens
     * Space Complexity: O(n) for the stack
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(performOperation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    private int performOperation(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return 0;
        }
    }
    
    /**
     * 4. Simplify Path
     * 
     * Problem: Given a string path, which is an absolute path to a file or directory in a Unix-style file system,
     * convert it to the simplified canonical path.
     * 
     * Time Complexity: O(n) where n is the length of the path
     * Space Complexity: O(n) for the stack
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String component : components) {
            if (component.equals(".") || component.isEmpty()) {
                continue;
            } else if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder result = new StringBuilder();
        for (String component : stack) {
            result.append("/").append(component);
        }
        
        return result.toString();
    }
    
    /**
     * 5. Largest Rectangle in Histogram
     * 
     * Problem: Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
     * return the area of the largest rectangle in the histogram.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the stack
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
                i++;
            } else {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }
        
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
    
    /**
     * 6. Basic Calculator
     * 
     * Problem: Given a string s representing a valid expression, implement a basic calculator to evaluate it.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        
        return result + sign * num;
    }
    
    /**
     * 7. Next Greater Element
     * 
     * Problem: Given an array, find the next greater element for each element in the array.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the stack
     */
    public int[] nextGreaterElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }
        
        return result;
    }
    
    /**
     * 8. Daily Temperatures
     * 
     * Problem: Given an array of integers temperatures representing the daily temperatures,
     * return an array answer such that answer[i] is the number of days you have to wait after the ith day
     * to get a warmer temperature.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the stack
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return result;
    }
    
    /**
     * 9. Remove K Digits
     * 
     * Problem: Given string num representing a non-negative integer num, and an integer k,
     * return the smallest possible integer after removing k digits from num.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack
     */
    public String removeKDigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        // Remove remaining k digits from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        // Build the result
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
    
    /**
     * 10. Asteroid Collision
     * 
     * Problem: Given an array asteroids representing asteroids in a row, return the state of the asteroids after all collisions.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the stack
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[]{};
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean exploded = false;
            
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break;
                }
            }
            
            if (!exploded) {
                stack.push(asteroid);
            }
        }
        
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
} 