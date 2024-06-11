package com.example.lovehistory.user.controller;

import com.example.lovehistory.user.dto.LoginReq;
import com.example.lovehistory.user.dto.UserReq;
import com.example.lovehistory.user.dto.UserRes;
import com.example.lovehistory.user.entity.User;
import com.example.lovehistory.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        List<UserRes> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<?> getUser(@PathVariable Long Id){
        User user = userService.getUser(Id);
        UserRes userRes = UserRes.fromEntity(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserReq userReq){
        User user = userService.createUser(userReq);
        UserRes userRes = UserRes.fromEntity(user);
        return ResponseEntity.ok(userRes);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<?> updateUser(@PathVariable Long Id, @RequestBody UserReq userReq){
        User user = userService.updateUser(Id, userReq);
        UserRes userRes = UserRes.fromEntity(user);
        return ResponseEntity.ok(userRes);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long Id){
        userService.deleteUser(Id);
        return ResponseEntity.ok().build();
    }




    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        Map<String, Object> loginResponse = userService.login(loginReq.getUserId(), loginReq.getPassword());
        if (loginResponse != null) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(401).body("로그인 실패: 잘못된 사용자 ID 또는 비밀번호");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        userService.logout(session);
        return ResponseEntity.ok("로그아웃 성공");
    }



}