package com.interview.datastructures;

/**
 * Trie Data Structure Interview Questions
 *
 * This class contains top 10 most important trie interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class TrieQuestions {
    // 1. Implement Trie (Prefix Tree)
    // 2. Word Search II
    // 3. Replace Words
    // 4. Design Add and Search Words Data Structure
    // 5. Longest Word in Dictionary
    // 6. Maximum XOR of Two Numbers in an Array
    // 7. Palindrome Pairs
    // 8. Stream of Characters
    // 9. Concatenated Words
    // 10. Prefix and Suffix Search

    // Example:
    /**
     * 1. Implement Trie (Prefix Tree)
     * Problem: Implement a trie with insert, search, and startsWith methods.
     * Time Complexity: O(L) per operation
     * Space Complexity: O(N*L)
     */
    public static class Trie {
        private TrieNode root = new TrieNode();
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
        }
    }

    // ... (other 9 questions will be added in the same style)
} 