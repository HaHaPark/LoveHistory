package com.example.lovehistory.couple.dto;

import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.user.entity.User;

import java.time.LocalDate;

public record CoupleRes(
        Long coupleId,
        LocalDate coupleDate,
        String couplecode,
        String userId1,
        String userId2
) {
    public static  CoupleRes fromCouple(Couple couple) {
        return new CoupleRes(couple.getCoupleId(), couple.getCoupleDate(), couple.getCouplecode(),couple.getUser1().getUsername(), couple.getUser2().getUsername());
    }
    
}