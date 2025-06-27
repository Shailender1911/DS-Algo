package com.interview.datastructures;

import java.util.*;

/**
 * LinkedList Data Structure Interview Questions
 * 
 * This class contains top 10 most important linked list manipulation interview questions
 * with detailed solutions, time complexity, and space complexity analysis.
 * 
 * @author Interview Guide Team
 * @version 1.0.0
 */
public class LinkedListQuestions {
    
    // Node class for LinkedList
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    /**
     * 1. Reverse Linked List
     * 
     * Problem: Given the head of a singly linked list, reverse the list, and return the reversed list.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
    
    /**
     * 2. Detect Cycle in Linked List (Floyd's Cycle Finding Algorithm)
     * 
     * Problem: Given head, the head of a linked list, determine if the linked list has a cycle in it.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * 3. Merge Two Sorted Lists
     * 
     * Problem: Merge two sorted linked lists and return it as a sorted list.
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the lists
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
    
    /**
     * 4. Remove Nth Node From End of List
     * 
     * Problem: Given the head of a linked list, remove the nth node from the end of the list.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
        // Move both pointers until first reaches end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node
        second.next = second.next.next;
        
        return dummy.next;
    }
    
    /**
     * 5. Add Two Numbers
     * 
     * Problem: You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * 
     * Time Complexity: O(max(n, m)) where n and m are the lengths of the lists
     * Space Complexity: O(max(n, m))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    /**
     * 6. Intersection of Two Linked Lists
     * 
     * Problem: Given the heads of two singly linked-lists headA and headB, return the node at which
     * the two lists intersect.
     * 
     * Time Complexity: O(n + m) where n and m are the lengths of the lists
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
    
    /**
     * 7. Palindrome Linked List
     * 
     * Problem: Given the head of a singly linked list, return true if it is a palindrome.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half
        ListNode secondHalf = reverseList(slow.next);
        ListNode firstHalf = head;
        
        // Compare the two halves
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    /**
     * 8. Remove Duplicates from Sorted List
     * 
     * Problem: Given the head of a sorted linked list, delete all duplicates such that each element
     * appears only once.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    /**
     * 9. Swap Nodes in Pairs
     * 
     * Problem: Given a linked list, swap every two adjacent nodes and return its head.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            prev = first;
        }
        
        return dummy.next;
    }
    
    /**
     * 10. Reverse Nodes in k-Group
     * 
     * Problem: Given the head of a linked list, reverse the nodes of the list k at a time,
     * and return the modified list.
     * 
     * Time Complexity: O(n) where n is the number of nodes
     * Space Complexity: O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        int count = 0;
        ListNode current = head;
        
        while (current != null) {
            count++;
            
            if (count % k == 0) {
                prev = reverseBetween(prev, current.next);
                current = prev.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode reverseBetween(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode current = start.next;
        ListNode first = current;
        
        while (current != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        start.next = prev;
        first.next = current;
        
        return first;
    }
} 