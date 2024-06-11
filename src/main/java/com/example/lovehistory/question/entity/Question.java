package com.example.lovehistory.question.entity;




import com.example.lovehistory.history.entity.History;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

        private String questionContent;

    @OneToMany(mappedBy = "question")
    private List<History> datingHistories;

    public Long getId() {
        return questionId;
    }


    // Add constructors, Getters, Setters (if needed), etc.
}

