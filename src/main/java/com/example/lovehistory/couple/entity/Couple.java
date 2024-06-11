package com.example.lovehistory.couple.entity;




import com.example.lovehistory.history.entity.History;
import com.example.lovehistory.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Data
public class Couple {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coupleId;

    private LocalDate coupleDate;

    private String couplecode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id1")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id2")
    private User user2;

    @OneToMany(mappedBy = "couple")
    private List<History> datingHistorie;


    public void setCoupleCode(String coupleCode) {
        this.couplecode = coupleCode;
    }



}
