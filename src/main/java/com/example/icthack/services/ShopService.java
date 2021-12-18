package com.example.icthack.services;

import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.EnventoryItemRepository;
import com.example.icthack.repositories.InventoryRepository;
import com.example.icthack.repositories.UserRepository;
import com.example.icthack.responses.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShopService {
    private final UserRepository userRepository;
    private final EnventoryItemRepository enventoryItemRepository;
    private final InventoryRepository inventoryRepository;
    public ShopService(UserRepository userRepository, EnventoryItemRepository enventoryItemRepository, InventoryRepository inventoryRepository) {
        this.userRepository = userRepository;
        this.enventoryItemRepository = enventoryItemRepository;
        this.inventoryRepository = inventoryRepository;
    }
    public boolean buy(Trade trade){
        Inventory inv = new Inventory();
        if (userRepository.findByIsu(trade.getUserId())==null) {
            return false;
        }
        inv.setUserId(trade.getUserId());
        inv.setItemId(trade.getItemId());
        inventoryRepository.save(inv);
        return true;
    }
}
