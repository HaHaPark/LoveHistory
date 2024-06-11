package com.example.lovehistory.couple.repository;

import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoupleRepository extends JpaRepository<Couple, Long> {

    @Query("SELECT c FROM Couple c WHERE c.couplecode = :coupleCode")
    Optional<Couple> findByCoupleCode(@Param("coupleCode") String coupleCode);

    @Query("SELECT c FROM Couple c WHERE c.user1.userId = :userId OR c.user2.userId = :userId")
    Optional<Couple> findCoupleByUserId(@Param("userId") String userId);
}