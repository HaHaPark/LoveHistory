package com.example.lovehistory.user.service;

import com.example.lovehistory.couple.dto.CoupleRes;
import com.example.lovehistory.couple.entity.Couple;
import com.example.lovehistory.couple.repository.CoupleRepository;
import com.example.lovehistory.user.dto.UserReq;
import com.example.lovehistory.user.dto.UserRes;
import com.example.lovehistory.user.entity.User;
import com.example.lovehistory.user.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CoupleRepository coupleRepository;

    public List<UserRes> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserRes::fromEntity)
                .collect(Collectors.toList());
    }

    public User getUser(Long Id) {
        return userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음"));
    }

    public User createUser(UserReq request) {
        User user = request.toEntity();
        System.out.println("Creating user with details: " + user);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(Long Id, UserReq request) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음"));


        user.update(request.userId(), request.username(), request.password(), request.phone());

        return user;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }



    public Map<String, Object> login(String userId, String password) {
        Optional<User> optionalUser = userRepository.findByUserIdAndPassword(userId, password);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Optional<Couple> optionalCouple = coupleRepository.findCoupleByUserId(user.getUserId());
            CoupleRes coupleRes = optionalCouple.map(CoupleRes::fromCouple).orElse(null);

            Map<String, Object> response = new HashMap<>();
            response.put("user", UserRes.fromEntity(user));
            response.put("couple", coupleRes);
            return response;
        } else {
            return null;
        }
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }
}