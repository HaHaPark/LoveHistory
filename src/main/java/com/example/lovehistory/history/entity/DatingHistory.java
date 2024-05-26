package com.example.lovehistory.history.entity;



import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.question.entity.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class DatingHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datingHistoryId;

    private LocalDateTime datingDate;

    private String history;

    @ManyToOne
    @JoinColumn(name = "coupleId")
    private Couple couple;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    // Add constructors, Getters, Setters (if needed), etc.
}
