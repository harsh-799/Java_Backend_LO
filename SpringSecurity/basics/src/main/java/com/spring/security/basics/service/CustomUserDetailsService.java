package com.spring.security.basics.service;

import com.spring.security.basics.model.User;
import com.spring.security.basics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userRecords = userRepository.findByUsername(username);

        if (userRecords == null) {
            throw new UsernameNotFoundException("User is not avaialble");
        }

        // Since User Details is Intf so we need Something which implements it so we have 🌱User class (Of spring)
        // 🌱User class implements the UserDetails intf
        // In that there's an Method named as builder() which returns as Obj of 🌱Userbuilder class
        // Using that obj of 🌱UserBuilder we assign (username, password, roles)
        // And in That UserBuilder class there's one method called .build() which returns the object of 🌱UserDetails
        // And ultimately we want that only so we return that obj.

        return org.springframework.security.core.userdetails.User.builder()
                .username(userRecords.getUsername())
                .password(userRecords.getPassword())
                .roles(userRecords.getRole())
                .build();


    }
}
