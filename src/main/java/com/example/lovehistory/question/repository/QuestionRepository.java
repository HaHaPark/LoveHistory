package com.example.lovehistory.question.repository;

import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
