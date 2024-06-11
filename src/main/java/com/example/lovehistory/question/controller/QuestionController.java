package com.example.lovehistory.question.controller;

import com.example.lovehistory.question.dto.QuestionReq;
import com.example.lovehistory.question.dto.QuestionRes;
import com.example.lovehistory.question.entity.Question;
import com.example.lovehistory.question.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public QuestionRes createQuestion(@RequestBody QuestionReq questionReq) {
        return questionService.createQuestion(questionReq.getQuestionContent());
    }

    @PutMapping("/{id}")
    public QuestionRes updateQuestion(@PathVariable Long id, @RequestBody QuestionReq questionReq) {
        return questionService.updateQuestion(id, questionReq.getQuestionContent());
    }

    @GetMapping("/{id}")
    public QuestionRes getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping
    public List<QuestionRes> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/random")
    public ResponseEntity<QuestionRes> getRandomQuestion() {
        QuestionRes randomQuestion = questionService.getRandomQuestion();
        return ResponseEntity.ok(randomQuestion);
    }

}