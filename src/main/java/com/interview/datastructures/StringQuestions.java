package com.interview.datastructures;

import com.interview.model.InterviewQuestion;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * String Data Structure Interview Questions
 * 
 * This class contains top 10 most important string manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 * 
 * @author Interview Guide Team
 * @version 1.0.0
 */
@Component
public class StringQuestions {
    
    /**
     * 1. Reverse a String
     * 
     * Problem: Given a string, reverse it without using any built-in reverse methods.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the result string
     */
    public String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    /**
     * 2. Check if String is Palindrome
     * 
     * Problem: Given a string, determine if it is a palindrome, considering only alphanumeric characters.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - using two pointers
     */
    public boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    /**
     * 3. Find First Non-Repeating Character
     * 
     * Problem: Given a string, find the first non-repeating character in it.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1) - fixed size array for ASCII characters
     */
    public char firstNonRepeatingCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }
        
        int[] charCount = new int[256];
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }
        
        // Find first character with count 1
        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }
        
        return '\0'; // No non-repeating character found
    }
    
    /**
     * 4. Longest Substring Without Repeating Characters
     * 
     * Problem: Given a string, find the length of the longest substring without repeating characters.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(min(m, n)) where m is the size of the character set
     */
    public int longestSubstringWithoutRepeating(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        Set<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int left = 0, right = 0;
        
        while (right < str.length()) {
            if (!charSet.contains(str.charAt(right))) {
                charSet.add(str.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                charSet.remove(str.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }
    
    /**
     * 5. Valid Anagram
     * 
     * Problem: Given two strings, determine if they are anagrams of each other.
     * 
     * Time Complexity: O(n) where n is the length of the strings
     * Space Complexity: O(1) - fixed size array for ASCII characters
     */
    public boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        
        int[] charCount = new int[256];
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            charCount[c]++;
        }
        
        // Decrement count for characters in second string
        for (char c : str2.toCharArray()) {
            charCount[c]--;
            if (charCount[c] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * 6. String to Integer (atoi)
     * 
     * Problem: Implement the atoi function that converts a string to an integer.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(1)
     */
    public int stringToInteger(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        
        int sign = 1;
        int index = 0;
        
        // Handle sign
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = (str.charAt(0) == '-') ? -1 : 1;
            index++;
        }
        
        long result = 0;
        
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            result = result * 10 + (str.charAt(index) - '0');
            
            // Handle overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && result > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            
            index++;
        }
        
        return (int) (sign * result);
    }
    
    /**
     * 7. Longest Common Prefix
     * 
     * Problem: Find the longest common prefix string amongst an array of strings.
     * 
     * Time Complexity: O(S) where S is the sum of all characters in all strings
     * Space Complexity: O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        if (strs.length == 1) {
            return strs[0];
        }
        
        // Find the shortest string length
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        
        StringBuilder prefix = new StringBuilder();
        
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);
            
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }
            
            prefix.append(currentChar);
        }
        
        return prefix.toString();
    }
    
    /**
     * 8. Valid Parentheses
     * 
     * Problem: Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * 
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(n) for the stack
     */
    public boolean isValidParentheses(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        
        for (char c : str.toCharArray()) {
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
     * 9. Group Anagrams
     * 
     * Problem: Given an array of strings, group the anagrams together.
     * 
     * Time Complexity: O(n * k * log k) where n is the number of strings and k is the max length
     * Space Complexity: O(n * k)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Sort the string to create a key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            anagramGroups.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
    
    /**
     * 10. Minimum Window Substring
     * 
     * Problem: Given two strings s and t, return the minimum window substring of s such that
     * every character in t (including duplicates) is included in the window.
     * 
     * Time Complexity: O(n) where n is the length of string s
     * Space Complexity: O(k) where k is the size of the character set
     */
    public String minimumWindowSubstring(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        
        // Count characters in t
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }
        
        int required = targetCount.size();
        int formed = 0;
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        
        Map<Character, Integer> windowCount = new HashMap<>();
        
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            windowCount.put(currentChar, windowCount.getOrDefault(currentChar, 0) + 1);
            
            if (targetCount.containsKey(currentChar) && 
                windowCount.get(currentChar).equals(targetCount.get(currentChar))) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);
                
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                
                if (targetCount.containsKey(leftChar) && 
                    windowCount.get(leftChar) < targetCount.get(leftChar)) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
} 