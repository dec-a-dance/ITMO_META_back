package com.example.icthack.services;


import com.example.icthack.entities.User;
import com.example.icthack.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Сервис,обеспечивающий необходимые методы для работы с аккаунтами авторизованных пользователей, а также их регистрации.
 */
@Slf4j
@Service
public class UserService{
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /** Метод, использующийся для получения данных о пользователе из базы данных по его номеру телефона. */
    public User findUserByPhoneNumber(long isu) {
        User user = userRepository.findByIsu(isu);
        if(user==null){
            log.debug("User with number {} not found.", isu);
            throw new NullPointerException("User with such phone number doesn't exist.");
        }
        else{
            log.debug("User with isu {} found.", isu);
            return user;
        }
    }
    /** Метод, использующийся для добавления нового авторизованного пользователя в базу данных. */
    public boolean addUser(User user){
        User newUser = new User();
        User foundUser = userRepository.findByIsu(user.getIsu());
        if (foundUser != null) {
            log.debug("User with phone number {} already exist", user.getIsu());
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public boolean updateUser(User user){
        User foundUser = userRepository.findByIsu(user.getIsu());
        if (foundUser == null) {
            log.debug("User with isu {} doesn't exist", user.getIsu());
            return false;
        }
        userRepository.save(user);
        return true;
    }
}
