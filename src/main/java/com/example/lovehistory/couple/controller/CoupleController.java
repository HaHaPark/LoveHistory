package com.example.lovehistory.couple.controller;

import com.example.lovehistory.couple.dto.CoupleRes;
import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.couple.repository.CoupleRepository;
import com.example.lovehistory.couple.service.CoupleService;
import com.example.lovehistory.user.entity.User;
import com.example.lovehistory.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/couple")
public class CoupleController {


    private CoupleService coupleService;
    private UserRepository userRepository;
    private CoupleRepository coupleRepository;

//    @PostMapping("/create/{Id}")
//    public String createCouple(@PathVariable("Id") Long Id, @RequestBody Couple couple) {
//        User user = userRepository.findById(Id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
//        return coupleService.createCouple(user, couple.getCoupleDate());
//    }
//
//    @PostMapping("/join/{Id}")
//    public String joinCouple(@PathVariable("Id") Long Id, @RequestParam String coupleCode) {
//        User user = userRepository.findById(Id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
//        boolean success = coupleService.joinCouple(coupleCode, user);
//        return success ? "Successfully joined couple" : "Failed to join couple";
//    }
@PostMapping("/create/{Id}")
public ResponseEntity<?> createCouple(@PathVariable("Id") Long Id, @RequestBody Couple couple) {
    User user = userRepository.findById(Id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
    String coupleCode = coupleService.createCouple(user, couple.getCoupleDate());
    Optional<Couple> createdCouple = coupleRepository.findByCoupleCode(coupleCode);
    if (createdCouple.isPresent()) {
        Map<String, Object> response = new HashMap<>();
        response.put("coupleId", createdCouple.get().getCoupleId());
        response.put("coupleCode", coupleCode);
        return ResponseEntity.ok(response);
    } else {
        return ResponseEntity.status(500).body("Could not create couple");
    }
}

    @PostMapping("/join/{Id}")
    public ResponseEntity<?> joinCouple(@PathVariable("Id") Long Id, @RequestParam String coupleCode) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        boolean success = coupleService.joinCouple(coupleCode, user);
        if (success) {
            Optional<Couple> joinedCouple = coupleRepository.findByCoupleCode(coupleCode);
            if (joinedCouple.isPresent()) {
                return ResponseEntity.ok(joinedCouple.get().getCoupleId());
            } else {
                return ResponseEntity.status(500).body("Could not find couple after joining");
            }
        } else {
            return ResponseEntity.status(400).body("Failed to join couple");
        }
    }

    @PutMapping("/{coupleId}")
    public ResponseEntity<CoupleRes> updateCoupleDate(
            @PathVariable("coupleId") Long coupleId,
            @RequestParam("coupleDate") LocalDate newDate) {
        CoupleRes updatedCouple = coupleService.updateCoupleDate(coupleId, newDate);
        return ResponseEntity.ok(updatedCouple);
    }


}