package com.interview.datastructures;

/**
 * Set Data Structure Interview Questions
 *
 * This class contains top 10 most important set interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class SetQuestions {
    // 1. Contains Duplicate
    // 2. Intersection of Two Arrays
    // 3. Happy Number
    // 4. Longest Consecutive Sequence
    // 5. Single Number
    // 6. Valid Sudoku
    // 7. Isomorphic Strings
    // 8. Word Pattern
    // 9. Find the Duplicate Number
    // 10. Find All Numbers Disappeared in an Array

    // Example:
    /**
     * 1. Contains Duplicate
     * Problem: Given an integer array nums, return true if any value appears at least twice.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    // ... (other 9 questions will be added in the same style)
} 