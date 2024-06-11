package com.example.lovehistory.history.entity;



import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.question.entity.Question;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@Getter
@Data
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



    // Add constructors, Getters, Setters (if needed), etc.
}
