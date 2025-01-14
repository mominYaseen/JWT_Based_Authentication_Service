package com.example.jwt_database_interaction.service.impl;

import com.example.jwt_database_interaction.entity.People;
import com.example.jwt_database_interaction.repo.PeopleRepo;
import com.example.jwt_database_interaction.service.PeopleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService implements PeopleServiceInterface {

    @Autowired
     PeopleRepo repo;

    @Override
    public People addUserToDb(People user) {
        return repo.save(user);
    }
}
