package com.example.lovehistory.user.dto;

import com.example.lovehistory.user.entity.User;

public record UserRes(
        Long id,

        String userid,
        String username,
        String password,
        String phone


) {
//    // 간단하게 파라미터가 여러개면? -> of, 단일 파라미터(주로 인스턴스)가 들어온다? -> from
//    public static UserRes of(Long id, String userid, String username, String phone,String password ) {
//        return new UserRes(id, userid, username, password, phone);
//    }


    public static UserRes fromEntity(User user) {
        return new UserRes(user.getId(), user.getUserId(),user.getUsername(), user.getPassword(), user.getPhone());
    }
}