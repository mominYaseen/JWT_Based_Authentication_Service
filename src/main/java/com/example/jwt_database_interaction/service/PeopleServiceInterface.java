package com.example.jwt_database_interaction.service;

import com.example.jwt_database_interaction.entity.People;
import org.springframework.stereotype.Repository;

public interface PeopleServiceInterface {

    People addUserToDb(People user);
}
