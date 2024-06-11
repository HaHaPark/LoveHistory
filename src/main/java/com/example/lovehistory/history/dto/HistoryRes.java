package com.example.lovehistory.history.dto;

import com.example.lovehistory.history.entity.History;
import com.example.lovehistory.user.dto.UserRes;
import com.example.lovehistory.user.entity.User;

import java.time.LocalDate;

public record HistoryRes(
        LocalDate datingDate,
        String datehistory,
        String answer,
        Long coupleId,
        Long questionId
){

    public static HistoryRes fromEntity(History history) {
        return new HistoryRes(history.getDatingDate(), history.getDatehistory(), history.getAnswer(), history.getCouple().getCoupleId(), history.getQuestion().getQuestionId());
    }

}
