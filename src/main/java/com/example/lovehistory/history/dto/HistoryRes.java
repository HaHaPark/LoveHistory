package com.example.lovehistory.history.dto;

import com.example.lovehistory.history.entity.History;
import com.example.lovehistory.question.dto.QuestionRes;
import com.example.lovehistory.user.dto.UserRes;
import com.example.lovehistory.user.entity.User;

import java.time.LocalDate;

public record HistoryRes(
        Long datingHistoryId,
        LocalDate datingDate,
        String datehistory,
        String answer,
        Long coupleId,
        QuestionRes question
){

    public static HistoryRes fromEntity(History history) {
        return new HistoryRes(
                history.getDatingHistoryId(),
                history.getDatingDate(),
                history.getDatehistory(),
                history.getAnswer(),
                history.getCouple().getCoupleId(),
                new QuestionRes(history.getQuestion().getQuestionId(), history.getQuestion().getQuestionContent())
        );
    }
}

