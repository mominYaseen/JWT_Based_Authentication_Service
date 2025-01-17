package com.example.jwt_database_interaction.service.impl;

import com.example.jwt_database_interaction.entity.People;
import com.example.jwt_database_interaction.repo.PeopleRepo;
import com.example.jwt_database_interaction.service.PeopleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleService implements PeopleServiceInterface , UserDetailsService {

    @Autowired
     PeopleRepo repo;

    @Override
    public People addUserToDb(People user) {
        return repo.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        People user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("INVALID USER"));
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
