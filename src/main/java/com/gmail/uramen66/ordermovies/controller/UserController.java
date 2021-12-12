package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.model.User;
import com.gmail.uramen66.ordermovies.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User response = userService.create(user);
        return ResponseEntity.ok().body(response);
    }
}
