package com.example.lovehistory.couple.dto;

import com.example.lovehistory.couple.entity.Couple;

import java.time.LocalDate;

public record CoupleRes(
        Long coupleId,
        LocalDate coupleDate,
        String couplecode
) {
    public static  CoupleRes fromCouple(Couple couple) {
        return new CoupleRes(couple.getCoupleId(), couple.getCoupleDate(), couple.getCouplecode());
    }
    
}