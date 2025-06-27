package com.interview.datastructures;

/**
 * Graph Data Structure Interview Questions
 *
 * This class contains top 10 most important graph interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class GraphQuestions {
    // 1. Number of Islands
    // 2. Clone Graph
    // 3. Course Schedule
    // 4. Graph Valid Tree
    // 5. Word Ladder
    // 6. Network Delay Time
    // 7. Minimum Spanning Tree (Kruskal/Prim)
    // 8. Dijkstra's Shortest Path
    // 9. Topological Sort
    // 10. Find the Town Judge

    // Example:
    /**
     * 1. Number of Islands
     * Problem: Given a 2D grid map of '1's (land) and '0's (water), count the number of islands.
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n)
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    // ... (other 9 questions will be added in the same style)
} 