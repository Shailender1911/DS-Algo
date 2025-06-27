package com.interview.datastructures;

import java.util.*;

/**
 * Array Data Structure Interview Questions
 * 
 * This class contains top 10 most important array manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 * 
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class ArrayQuestions {
    
    /**
     * 1. Two Sum
     * 
     * Problem: Given an array of integers nums and an integer target, return indices of the two numbers
     * such that they add up to target.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the HashMap
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            
            numMap.put(nums[i], i);
        }
        
        return new int[]{};
    }
    
    /**
     * 2. Maximum Subarray (Kadane's Algorithm)
     * 
     * Problem: Given an integer array nums, find the contiguous subarray with the largest sum.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    /**
     * 3. Best Time to Buy and Sell Stock
     * 
     * Problem: Given an array prices where prices[i] is the price of a given stock on the ith day,
     * find the maximum profit you can achieve.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        
        return maxProfit;
    }
    
    /**
     * 4. Product of Array Except Self
     * 
     * Problem: Given an integer array nums, return an array answer such that answer[i] is equal to
     * the product of all the elements of nums except nums[i].
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) excluding the output array
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate left products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and combine
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }
    
    /**
     * 5. Contains Duplicate
     * 
     * Problem: Given an integer array nums, return true if any value appears at least twice in the array.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(n) for the HashSet
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            if (!numSet.add(num)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 6. Rotate Array
     * 
     * Problem: Given an array, rotate the array to the right by k steps, where k is non-negative.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     */
    public void rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        
        int n = nums.length;
        k = k % n; // Handle cases where k > n
        
        // Reverse the entire array
        reverse(nums, 0, n - 1);
        
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Reverse the remaining elements
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    /**
     * 7. Merge Sorted Array
     * 
     * Problem: Given two sorted arrays nums1 and nums2, merge them into nums1 in sorted order.
     * 
     * Time Complexity: O(m + n) where m and n are the lengths of the arrays
     * Space Complexity: O(1)
     */
    public void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        
        // Copy remaining elements from nums2
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
    
    /**
     * 8. Move Zeroes
     * 
     * Problem: Given an integer array nums, move all 0's to the end while maintaining the relative order
     * of the non-zero elements.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        int nonZeroIndex = 0;
        
        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        
        // Fill the rest with zeros
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
    
    /**
     * 9. Find Missing Number
     * 
     * Problem: Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1)
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    /**
     * 10. Find All Duplicates in Array
     * 
     * Problem: Given an integer array nums of length n where all the integers of nums are in the range [1, n]
     * and each integer appears once or twice, return an array of all the integers that appears twice.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(1) excluding the output list
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length < 2) {
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }
    // next permutation
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 