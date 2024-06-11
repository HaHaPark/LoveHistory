package com.example.lovehistory.history.entity;



import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.question.entity.Question;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long datingHistoryId;

    private LocalDate datingDate;

    private String datehistory;

    @ManyToOne
    @JoinColumn(name = "coupleId")
    private Couple couple;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "questionId")
    private Question question;

    @Builder
    public History(  LocalDate datingDate,
                    String datehistory,
                    String answer){
        this.datingDate = datingDate;
        this.datehistory = datehistory;
        this.answer = answer;


    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCouple(Couple couple) {
        this.couple = couple;
    }


    // Add constructors, Getters, Setters (if needed), etc.
}
