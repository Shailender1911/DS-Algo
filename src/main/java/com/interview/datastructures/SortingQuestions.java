package com.interview.datastructures;

/**
 * Sorting Interview Questions
 *
 * This class contains top 10 most important sorting interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 *
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class SortingQuestions {
    // 1. Bubble Sort
    // 2. Selection Sort
    // 3. Insertion Sort
    // 4. Merge Sort
    // 5. Quick Sort
    // 6. Heap Sort
    // 7. Counting Sort
    // 8. Radix Sort
    // 9. Sort Colors (Dutch National Flag)
    // 10. Top K Frequent Elements

    // Example:
    /**
     * 1. Bubble Sort
     * Problem: Sort an array using bubble sort algorithm.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ... (other 9 questions will be added in the same style)
} 