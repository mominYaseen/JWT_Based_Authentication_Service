package com.example.jwt_database_interaction.controller;

import com.example.jwt_database_interaction.entity.People;
import com.example.jwt_database_interaction.service.PeopleServiceInterface;
import com.example.jwt_database_interaction.service.impl.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class Controller {

    @Autowired
    private PeopleService peopleServiceInterface;

    @PostMapping("/register")
    public People registerUserToDb(@RequestBody People user){

        return peopleServiceInterface.addUserToDb(user);
    }

}
