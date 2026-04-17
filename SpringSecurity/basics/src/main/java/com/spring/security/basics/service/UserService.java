package com.spring.security.basics.service;

import com.spring.security.basics.model.User;
import com.spring.security.basics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUsers(User user) {
        userRepository.save(user);
    }
}
