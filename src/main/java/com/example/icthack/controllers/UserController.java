package com.example.icthack.controllers;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.UserRepository;
import com.example.icthack.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Контроллер, обеспечивающий маппинг и обработку запросов, связанных с авторизацией и регистрацией пользователей.
 */
@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/auth")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** Маппинг и обработка запросов, связанных с авторизацией уже зарегистрированных пользователей. */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser;
        try {
            foundUser = userService.findUserByPhoneNumber(user.getIsu());
        }
        catch(Exception e) {
            return new ResponseEntity<>("Such card number doesn't exist.", HttpStatus.BAD_REQUEST);
        }
        if(Objects.equals(user.getPassword(), foundUser.getPassword())){
            return new ResponseEntity<>("Logined successfully.", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Wrong login/password combination.", HttpStatus.BAD_REQUEST);
        }
    }
    /** Маппинг и обработка запросов, связанных с регистрацией новых пользователей. */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if(userService.addUser(user)){
            return new ResponseEntity<>("Registered successfully.", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Such user already exist.", HttpStatus.BAD_REQUEST);
        }
    }
}
