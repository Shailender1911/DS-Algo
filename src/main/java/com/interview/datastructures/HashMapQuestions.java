package com.interview.datastructures;

/**
 * HashTable/HashMap Data Structure Interview Questions
 *
 * This class contains top 10 most important hash table/hash map interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class HashMapQuestions {
    // 1. Two Sum
    // 2. Group Anagrams
    // 3. Subarray Sum Equals K
    // 4. Longest Consecutive Sequence
    // 5. LRU Cache
    // 6. Top K Frequent Elements
    // 7. Isomorphic Strings
    // 8. Word Pattern
    // 9. Find All Anagrams in a String
    // 10. Minimum Window Substring

    // Example:
    /**
     * 1. Two Sum
     * Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }

    // ... (other 9 questions will be added in the same style)
} 