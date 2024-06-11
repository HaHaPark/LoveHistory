package com.example.lovehistory.user.entity;


import com.example.lovehistory.couple.entity.Couple;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private String phone;

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Couple> couplesAsUser1;


    @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL)
    private List<Couple> couplesAsUser2;


    @Builder
    public User( String userId, String username, String password, String phone) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    //편의 메서드
    public void update( String userId, String username,  String phone, String password ) {

        this.userId = userId;
        this.username = username;
        this.password = phone;
        this.phone = password;

    }
}
