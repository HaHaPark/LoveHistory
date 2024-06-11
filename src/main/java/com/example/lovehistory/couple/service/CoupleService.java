package com.example.lovehistory.couple.service;

import com.example.lovehistory.couple.dto.CoupleRes;
import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.couple.repository.CoupleRepository;
import com.example.lovehistory.user.entity.User;
import com.example.lovehistory.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CoupleService {

    @Autowired
    private CoupleRepository coupleRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String CODE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;

    @Transactional
    public String createCouple(User user,  LocalDate coupleDate) {
        String coupleCode = generateRandomCode();
        Couple couple = new Couple();
        couple.setUser1(user);
        couple.setCoupleCode(coupleCode);
        couple.setCoupleDate(coupleDate);

        coupleRepository.save(couple);
        return coupleCode;
    }

    @Transactional
    public boolean joinCouple(String coupleCode, User user) {
        Optional<Couple> optionalCouple = coupleRepository.findByCoupleCode(coupleCode);
        if (optionalCouple.isPresent()) {
            Couple couple = optionalCouple.get();
            if (couple.getUser2() == null) {
                couple.setUser2(user);
                coupleRepository.save(couple);
                return true;
            }
        }
        return false;
    }

    private String generateRandomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(CODE_CHARACTERS.charAt(random.nextInt(CODE_CHARACTERS.length())));
        }
        return sb.toString();
    }

    @Transactional
    public CoupleRes updateCoupleDate(Long coupleId, LocalDate newDate) {
        Couple couple = coupleRepository.findById(coupleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid couple ID: " + coupleId));
        couple.setCoupleDate(newDate);
        coupleRepository.save(couple);
        return CoupleRes.fromCouple(couple);
    }


}