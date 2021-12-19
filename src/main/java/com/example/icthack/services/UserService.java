package com.example.icthack.services;


import com.example.icthack.entities.EnventoryItem;
import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.EnventoryItemRepository;
import com.example.icthack.repositories.InventoryRepository;
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
    private final InventoryRepository inventoryRepository;
    private final EnventoryItemRepository itemRep;
    public UserService(UserRepository userRepository, InventoryRepository inventoryRepository, EnventoryItemRepository itemRep) {
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
        this.itemRep = itemRep;
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
        var createdUser = userRepository.save(user);
        EnventoryItem item1 = new EnventoryItem();
        EnventoryItem item2 = new EnventoryItem();
        EnventoryItem item3 = new EnventoryItem();
        item1.setTypeId(1);
        item1 = itemRep.save(item1);
        item2.setTypeId(7);
        item2 = itemRep.save(item2);
        item3.setTypeId(10);
        item3 = itemRep.save(item3);
        Inventory inv1 = new Inventory();
        Inventory inv2 = new Inventory();
        Inventory inv3 = new Inventory();
        inv1.setUserId(createdUser.getIsu());
        inv1.setItemId(item1.getUniqId());
        inventoryRepository.save(inv1);
        inv2.setUserId(createdUser.getIsu());
        inv2.setItemId(item2.getUniqId());
        inventoryRepository.save(inv2);
        inv3.setUserId(createdUser.getIsu());
        inv3.setItemId(item3.getUniqId());
        inventoryRepository.save(inv3);
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
