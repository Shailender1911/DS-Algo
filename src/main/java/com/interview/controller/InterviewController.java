package com.interview.controller;

import com.interview.model.InterviewQuestion;
import com.interview.service.InterviewQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class InterviewController {
    private final InterviewQuestionService questionService;

    @Autowired
    public InterviewController(InterviewQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/categories")
    public ResponseEntity<Set<String>> getAllCategories() {
        return ResponseEntity.ok(questionService.getAllCategories());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<InterviewQuestion>> getQuestionsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(questionService.getQuestionsByCategory(category));
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Interview Guide API is running!");
    }
} 