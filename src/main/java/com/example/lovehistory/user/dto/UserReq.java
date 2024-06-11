package com.example.lovehistory.user.dto;

import com.example.lovehistory.user.entity.User;

public record UserReq(

        String userId,
        String username,
        String phone,
        String password


) {
    public User toEntity() {
        return User.builder()

                .userId(userId)
                .username(username)
                .phone(phone)
                .password(password)
                .build();
    }
}