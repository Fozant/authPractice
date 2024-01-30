package com.fauzan.authPractice.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fauzan.authPractice.Repo.UserRepo;
import com.fauzan.authPractice.model.User;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    private final UserRepo userRepo;

    @GetMapping
    public ResponseEntity<String> sayHello( )
        {
            return ResponseEntity.ok("hellow from secure endpoint");
        }

   @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepo.findAll();
        
        return ResponseEntity.ok(users);
    }
    @GetMapping("/user")
    public List<User> getAllUser() {

        
        return   userRepo.findAll();
    }
}
