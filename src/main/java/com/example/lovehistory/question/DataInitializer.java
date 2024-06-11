package com.example.lovehistory.question;

import com.example.lovehistory.question.entity.Question;
import com.example.lovehistory.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Autowired
    public DataInitializer(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 데이터가 이미 존재하는지 확인
        if (questionRepository.count() == 0) {
            // 데이터 삽입
            Question question1 = new Question();
            question1.setQuestionId(1L); // ID를 직접 설정
            question1.setQuestionContent("안녕?");

            Question question2 = new Question();
            question2.setQuestionId(2L); // ID를 직접 설정
            question2.setQuestionContent("안녕?안녕?");

            // 저장
            questionRepository.save(question1);
            questionRepository.save(question2);
        }
    }
}
