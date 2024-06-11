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
            question1.setQuestionContent("가장 마음에 들었던 장소는?");

            Question question2 = new Question();
            question2.setQuestionId(2L); // ID를 직접 설정
            question2.setQuestionContent("오늘 느꼈던 애인의 배려는?");

            Question question3 = new Question();
            question3.setQuestionId(3L); // ID를 직접 설정
            question3.setQuestionContent("가장 맛있었던 음식은?");

            Question question4 = new Question();
            question4.setQuestionId(4L); // ID를 직접 설정
            question4.setQuestionContent("애인에게 칭찬 한 마디");

            Question question5 = new Question();
            question5.setQuestionId(5L); // ID를 직접 설정
            question5.setQuestionContent("이런 부분은 마음에 들지 않아!");

            // 저장
            questionRepository.save(question1);
            questionRepository.save(question2);
            questionRepository.save(question3);
            questionRepository.save(question4);
            questionRepository.save(question5);
        }
    }
}
