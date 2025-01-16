package com.example.jwt_database_interaction.controller;

import com.example.jwt_database_interaction.entity.People;
import com.example.jwt_database_interaction.service.PeopleServiceInterface;
import com.example.jwt_database_interaction.service.impl.PeopleService;
import com.example.jwt_database_interaction.utils.JwtUtils;
import com.mysql.cj.util.DnsSrv;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
//@RequestMapping("/api")
public class Controller {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/register")
    public People registerUserToDb(@RequestBody People user){

        return peopleService.addUserToDb(user);
    }

    @GetMapping("/info")
    public String getInfo(){
        return "info method called";
    }

//

    @PostMapping("/login")
    public String login(@RequestParam String email ,@RequestParam String password ){
        UserDetails user = peopleService.loadUserByUsername(email);

        if (user!=null && user.getPassword().equals(password)){
            return jwtUtils.generateToken(email);
        }else{
            return "INVALID CREDENTIALS";
        }
    }
    @GetMapping("/secure-api")
    public String secureApi(@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            // Validate the token
            if (jwtUtils.validateToken(token)) {
                return "This is a secured API, token validated!";
            } else {
                return "Invalid token!";
            }
        } else {
            return "Authorization header is missing or malformed!";
        }
    }
}
