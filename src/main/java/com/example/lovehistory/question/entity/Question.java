package com.example.lovehistory.question.entity;



import com.example.lovehistory.history.entity.DatingHistory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionContent;

    @OneToMany(mappedBy = "question")
    private List<DatingHistory> datingHistories;

    // Add constructors, Getters, Setters (if needed), etc.
}

