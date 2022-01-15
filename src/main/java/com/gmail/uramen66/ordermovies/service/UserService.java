package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.model.User;
import com.gmail.uramen66.ordermovies.service.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user){
        return userRepository.save(user);
    }
}
