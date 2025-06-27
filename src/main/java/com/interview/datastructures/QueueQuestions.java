package com.interview.datastructures;

import java.util.*;

/**
 * Queue Data Structure Interview Questions
 * 
 * This class contains top 10 most important queue manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 * 
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class QueueQuestions {
    
    /**
     * 1. Implement Stack using Queues
     * 
     * Problem: Implement a last-in-first-out (LIFO) stack using only two queues.
     * 
     * Time Complexity: O(n) for push, O(1) for pop and top
     * Space Complexity: O(n) where n is the number of elements
     */
    public static class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }
        
        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
        
        public int pop() {
            return queue1.poll();
        }
        
        public int top() {
            return queue1.peek();
        }
        
        public boolean empty() {
            return queue1.isEmpty();
        }
    }
    
    /**
     * 2. Implement Queue using Stacks
     * 
     * Problem: Implement a first-in-first-out (FIFO) queue using only two stacks.
     * 
     * Time Complexity: O(1) for push, O(n) for pop and peek (amortized O(1))
     * Space Complexity: O(n) where n is the number of elements
     */
    public static class MyQueue {
        private Stack<Integer> stack1; // for pushing
        private Stack<Integer> stack2; // for popping
        
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }
        
        public void push(int x) {
            stack1.push(x);
        }
        
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        
        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
        
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
    
    /**
     * 3. Circular Queue Implementation
     * 
     * Problem: Design your implementation of the circular queue.
     * 
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(k) where k is the capacity
     */
    public static class MyCircularQueue {
        private int[] queue;
        private int head;
        private int tail;
        private int size;
        private int capacity;
        
        public MyCircularQueue(int k) {
            queue = new int[k];
            head = -1;
            tail = -1;
            size = 0;
            capacity = k;
        }
        
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            
            if (isEmpty()) {
                head = 0;
            }
            
            tail = (tail + 1) % capacity;
            queue[tail] = value;
            size++;
            return true;
        }
        
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            
            if (head == tail) {
                head = -1;
                tail = -1;
            } else {
                head = (head + 1) % capacity;
            }
            size--;
            return true;
        }
        
        public int Front() {
            return isEmpty() ? -1 : queue[head];
        }
        
        public int Rear() {
            return isEmpty() ? -1 : queue[tail];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
    }
    
    /**
     * 4. Sliding Window Maximum
     * 
     * Problem: Given an array nums, there is a sliding window of size k which is moving from the very left
     * of the array to the very right. Return the max sliding window.
     * 
     * Time Complexity: O(n) where n is the length of the array
     * Space Complexity: O(k) where k is the window size
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // Remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
    
    /**
     * 5. Number of Islands (BFS)
     * 
     * Problem: Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
     * return the number of islands using BFS.
     * 
     * Time Complexity: O(m * n) where m and n are the dimensions of the grid
     * Space Complexity: O(min(m, n)) for the queue
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void bfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0';
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int[] dir : directions) {
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
    
    /**
     * 6. Open the Lock
     * 
     * Problem: You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
     * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
     * 
     * Time Complexity: O(10^4) = O(10000) in worst case
     * Space Complexity: O(10000) for the visited set and queue
     */
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        if (deadSet.contains("0000")) {
            return -1;
        }
        
        queue.offer("0000");
        visited.add("0000");
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return level;
                }
                
                // Generate all possible next combinations
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] chars = current.toCharArray();
                        chars[j] = (char) ((chars[j] - '0' + k + 10) % 10 + '0');
                        String next = new String(chars);
                        
                        if (!deadSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
    
    /**
     * 7. Perfect Squares
     * 
     * Problem: Given an integer n, return the least number of perfect square numbers that sum to n.
     * 
     * Time Complexity: O(n * sqrt(n)) where n is the input number
     * Space Complexity: O(n) for the queue and visited set
     */
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                
                for (int j = 1; j * j <= current; j++) {
                    int next = current - j * j;
                    
                    if (next == 0) {
                        return level;
                    }
                    
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        
        return level;
    }
    
    /**
     * 8. Course Schedule (BFS)
     * 
     * Problem: Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
     * you should take to finish all courses using BFS (Topological Sort).
     * 
     * Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
     * Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }
        
        // Build adjacency list and in-degree count
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        
        // BFS with topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] result = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        return index == numCourses ? result : new int[]{};
    }
    
    /**
     * 9. Word Ladder
     * 
     * Problem: Given two words, beginWord and endWord, and a dictionary wordList, return the number of words
     * in the shortest transformation sequence from beginWord to endWord.
     * 
     * Time Complexity: O(26 * wordLength * wordListSize)
     * Space Complexity: O(wordListSize)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(endWord)) {
                    return level;
                }
                
                // Generate all possible transformations
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        
                        if (wordSet.contains(next)) {
                            queue.offer(next);
                            wordSet.remove(next);
                        }
                    }
                    chars[j] = original;
                }
            }
            level++;
        }
        
        return 0;
    }
    
    /**
     * 10. Design Hit Counter
     * 
     * Problem: Design a hit counter which counts the number of hits received in the past 5 minutes.
     * 
     * Time Complexity: O(1) for hit and getHits operations
     * Space Complexity: O(300) = O(1) since we only store 5 minutes of data
     */
    public static class HitCounter {
        private Queue<Integer> hits;
        
        public HitCounter() {
            hits = new LinkedList<>();
        }
        
        public void hit(int timestamp) {
            hits.offer(timestamp);
        }
        
        public int getHits(int timestamp) {
            // Remove hits older than 5 minutes (300 seconds)
            while (!hits.isEmpty() && hits.peek() <= timestamp - 300) {
                hits.poll();
            }
            return hits.size();
        }
    }
} 