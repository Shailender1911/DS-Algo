package com.interview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterviewQuestion {
    private Long id;
    private String title;
    private String description;
    private String difficulty; // EASY, MEDIUM, HARD
    private String category; // STRING, ARRAY, LINKEDLIST, STACK, QUEUE, TREE, BST, etc.
    private String problemStatement;
    private String solution;
    private String timeComplexity;
    private String spaceComplexity;
    private List<String> examples;
    private List<String> constraints;
    private List<String> approach;
    private String code;
    private List<String> testCases;
    private String explanation;
    private List<String> relatedTopics;
    private Integer estimatedTime; // in minutes
    private String company; // Companies that ask this question
    private Double frequency; // How frequently this question is asked (0.0 to 1.0)
} 