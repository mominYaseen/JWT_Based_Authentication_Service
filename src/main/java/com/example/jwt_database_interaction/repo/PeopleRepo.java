package com.example.jwt_database_interaction.repo;

import com.example.jwt_database_interaction.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepo extends JpaRepository<People , Integer> {
        Optional<People> findByEmail(String email);
}
