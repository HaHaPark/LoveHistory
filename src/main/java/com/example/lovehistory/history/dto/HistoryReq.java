package com.example.lovehistory.history.dto;

import com.example.lovehistory.history.entity.History;

import java.time.LocalDate;

public record HistoryReq(
        LocalDate datingDate,
        String datehistory,
        String answer
) {
    public History toEntity() {
        return History.builder()

                .datingDate(datingDate)
                .datehistory(datehistory)
                .answer(answer)
                .build();
    }
}