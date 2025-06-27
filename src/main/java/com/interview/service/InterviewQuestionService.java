package com.interview.service;

import com.interview.model.InterviewQuestion;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class InterviewQuestionService {
    private final Map<String, List<InterviewQuestion>> questionsByCategory = new HashMap<>();

    public InterviewQuestionService() {
        // Sample data for each topic
        questionsByCategory.put("STRING", List.of(
            InterviewQuestion.builder()
                .id(1L)
                .title("Reverse a String")
                .category("STRING")
                .difficulty("EASY")
                .problemStatement("Given a string, reverse it without using any built-in reverse methods.")
                .solution("Use two pointers to swap characters from both ends.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public String reverseString(String str) { ... }")
                .explanation("We use two pointers to swap characters from both ends until they meet in the middle.")
                .build()
        ));
        questionsByCategory.put("ARRAY", List.of(
            InterviewQuestion.builder()
                .id(2L)
                .title("Two Sum")
                .category("ARRAY")
                .difficulty("EASY")
                .problemStatement("Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.")
                .solution("Use a HashMap to store visited numbers and their indices.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public int[] twoSum(int[] nums, int target) { ... }")
                .explanation("We use a HashMap to check if the complement exists for each number.")
                .build()
        ));
        questionsByCategory.put("LINKEDLIST", List.of(
            InterviewQuestion.builder()
                .id(3L)
                .title("Reverse Linked List")
                .category("LINKEDLIST")
                .difficulty("EASY")
                .problemStatement("Given the head of a singly linked list, reverse the list, and return the reversed list.")
                .solution("Iteratively reverse the pointers of the list.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(1)")
                .code("public ListNode reverseList(ListNode head) { ... }")
                .explanation("We use three pointers to reverse the list in-place.")
                .build()
        ));
        questionsByCategory.put("STACK", List.of(
            InterviewQuestion.builder()
                .id(4L)
                .title("Valid Parentheses")
                .category("STACK")
                .difficulty("EASY")
                .problemStatement("Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.")
                .solution("Use a stack to match opening and closing brackets.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public boolean isValidParentheses(String s) { ... }")
                .explanation("We push opening brackets to the stack and pop for closing brackets.")
                .build()
        ));
        questionsByCategory.put("QUEUE", List.of(
            InterviewQuestion.builder()
                .id(5L)
                .title("Implement Stack using Queues")
                .category("QUEUE")
                .difficulty("EASY")
                .problemStatement("Implement a last-in-first-out (LIFO) stack using only two queues.")
                .solution("Use two queues to simulate stack operations.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public class MyStack { ... }")
                .explanation("Push to one queue and dequeue/enqueue to maintain order.")
                .build()
        ));
        questionsByCategory.put("TREE", List.of(
            InterviewQuestion.builder()
                .id(6L)
                .title("Maximum Depth of Binary Tree")
                .category("TREE")
                .difficulty("EASY")
                .problemStatement("Given the root of a binary tree, return its maximum depth.")
                .solution("Use recursion to find the max depth of left and right subtrees.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(h)")
                .code("public int maxDepth(TreeNode root) { ... }")
                .explanation("Recursively compute the depth of left and right subtrees.")
                .build()
        ));
        questionsByCategory.put("BST", List.of(
            InterviewQuestion.builder()
                .id(7L)
                .title("Search in a Binary Search Tree")
                .category("BST")
                .difficulty("EASY")
                .problemStatement("Given the root of a BST and a value, return the node with that value.")
                .solution("Recursively search left or right subtree based on value.")
                .timeComplexity("O(h)")
                .spaceComplexity("O(1)")
                .code("public TreeNode searchBST(TreeNode root, int val) { ... }")
                .explanation("Use BST property to search efficiently.")
                .build()
        ));
        questionsByCategory.put("HEAP", List.of(
            InterviewQuestion.builder()
                .id(8L)
                .title("Find Kth Largest Element in an Array")
                .category("HEAP")
                .difficulty("MEDIUM")
                .problemStatement("Given an integer array nums and an integer k, return the kth largest element.")
                .solution("Use a min-heap of size k.")
                .timeComplexity("O(n log k)")
                .spaceComplexity("O(k)")
                .code("public int findKthLargest(int[] nums, int k) { ... }")
                .explanation("Maintain a min-heap of size k to track the largest elements.")
                .build()
        ));
        questionsByCategory.put("TRIE", List.of(
            InterviewQuestion.builder()
                .id(9L)
                .title("Implement Trie (Prefix Tree)")
                .category("TRIE")
                .difficulty("MEDIUM")
                .problemStatement("Implement a trie with insert, search, and startsWith methods.")
                .solution("Use a tree structure with nodes for each character.")
                .timeComplexity("O(L)")
                .spaceComplexity("O(N*L)")
                .code("public class Trie { ... }")
                .explanation("Each node represents a character and has up to 26 children.")
                .build()
        ));
        questionsByCategory.put("SET", List.of(
            InterviewQuestion.builder()
                .id(10L)
                .title("Contains Duplicate")
                .category("SET")
                .difficulty("EASY")
                .problemStatement("Given an integer array nums, return true if any value appears at least twice.")
                .solution("Use a HashSet to track seen numbers.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public boolean containsDuplicate(int[] nums) { ... }")
                .explanation("Add each number to a set and check for duplicates.")
                .build()
        ));
        questionsByCategory.put("HASHMAP", List.of(
            InterviewQuestion.builder()
                .id(11L)
                .title("Two Sum (HashMap)")
                .category("HASHMAP")
                .difficulty("EASY")
                .problemStatement("Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.")
                .solution("Use a HashMap to store visited numbers and their indices.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(n)")
                .code("public int[] twoSum(int[] nums, int target) { ... }")
                .explanation("We use a HashMap to check if the complement exists for each number.")
                .build()
        ));
        questionsByCategory.put("GRAPH", List.of(
            InterviewQuestion.builder()
                .id(12L)
                .title("Number of Islands")
                .category("GRAPH")
                .difficulty("MEDIUM")
                .problemStatement("Given a 2D grid map of '1's (land) and '0's (water), count the number of islands.")
                .solution("Use DFS or BFS to traverse each island.")
                .timeComplexity("O(m*n)")
                .spaceComplexity("O(m*n)")
                .code("public int numIslands(char[][] grid) { ... }")
                .explanation("Mark visited land and count connected components.")
                .build()
        ));
        questionsByCategory.put("DP", List.of(
            InterviewQuestion.builder()
                .id(13L)
                .title("Climbing Stairs")
                .category("DP")
                .difficulty("EASY")
                .problemStatement("You are climbing a staircase. It takes n steps to reach the top. Each time you can climb 1 or 2 steps. How many distinct ways can you climb to the top?")
                .solution("Use dynamic programming to store the number of ways to reach each step.")
                .timeComplexity("O(n)")
                .spaceComplexity("O(1)")
                .code("public int climbStairs(int n) { ... }")
                .explanation("The number of ways to reach step n is the sum of ways to reach n-1 and n-2.")
                .build()
        ));
        questionsByCategory.put("SORTING", List.of(
            InterviewQuestion.builder()
                .id(14L)
                .title("Bubble Sort")
                .category("SORTING")
                .difficulty("EASY")
                .problemStatement("Sort an array using bubble sort algorithm.")
                .solution("Repeatedly swap adjacent elements if they are in the wrong order.")
                .timeComplexity("O(n^2)")
                .spaceComplexity("O(1)")
                .code("public void bubbleSort(int[] arr) { ... }")
                .explanation("Bubble up the largest element to the end in each pass.")
                .build()
        ));
    }

    public List<InterviewQuestion> getQuestionsByCategory(String category) {
        return questionsByCategory.getOrDefault(category.toUpperCase(), new ArrayList<>());
    }

    public Set<String> getAllCategories() {
        return questionsByCategory.keySet();
    }
} 