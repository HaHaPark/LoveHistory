package com.example.lovehistory.question.service;

import com.example.lovehistory.question.dto.QuestionRes;
import com.example.lovehistory.question.entity.Question;
import com.example.lovehistory.question.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionRes createQuestion(String questionContent) {
        Question question = new Question();
        question.setQuestionContent(questionContent);
        Question savedQuestion = questionRepository.save(question);
        return new QuestionRes(savedQuestion.getId(), savedQuestion.getQuestionContent());
    }

    public QuestionRes updateQuestion(Long id, String questionContent) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        question.setQuestionContent(questionContent);
        Question updatedQuestion = questionRepository.save(question);
        return new QuestionRes(updatedQuestion.getId(), updatedQuestion.getQuestionContent());
    }

    public QuestionRes getQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid question ID"));
        return new QuestionRes(question.getId(), question.getQuestionContent());
    }

    public List<QuestionRes> getAllQuestions() {
        return questionRepository.findAll().stream()
                .map(question -> new QuestionRes(question.getId(), question.getQuestionContent()))
                .collect(Collectors.toList());
    }

    public QuestionRes getRandomQuestion() {
        Random random = new Random();
        Long randomQuestionId = (long) (random.nextInt(5) + 1); // 1~10 사이의 랜덤 숫자 생성
        Optional<Question> questionOpt = questionRepository.findById(randomQuestionId);
        Question question = questionOpt.orElseThrow(() -> new IllegalArgumentException("Invalid questionId"));
        return new QuestionRes(question.getId(), question.getQuestionContent());
    }
}