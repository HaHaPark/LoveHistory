package com.example.lovehistory.couple.entity;



import com.example.lovehistory.history.entity.DatingHistory;
import com.example.lovehistory.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coupleId;

    private LocalDateTime coupleDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2")
    private User user2;

    @OneToMany(mappedBy = "couple")
    private List<DatingHistory> datingHistorie;

    // Add constructors, Getters, Setters (if needed), etc.
}
