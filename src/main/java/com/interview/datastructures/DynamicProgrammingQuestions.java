package com.interview.datastructures;

/**
 * Dynamic Programming Interview Questions
 *
 * This class contains top 10 most important DP interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class DynamicProgrammingQuestions {
    // 1. Climbing Stairs
    // 2. House Robber
    // 3. Coin Change
    // 4. Longest Increasing Subsequence
    // 5. Longest Common Subsequence
    // 6. Edit Distance
    // 7. Maximum Subarray
    // 8. Decode Ways
    // 9. Unique Paths
    // 10. Word Break

    // Example:
    /**
     * 1. Climbing Stairs
     * Problem: You are climbing a staircase. It takes n steps to reach the top. Each time you can climb 1 or 2 steps. How many distinct ways can you climb to the top?
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // ... (other 9 questions will be added in the same style)
} 