package com.example.lovehistory.user.repository;

import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.user.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserIdAndPassword(String userId, String password);



}


