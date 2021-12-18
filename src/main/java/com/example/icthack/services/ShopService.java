package com.example.icthack.services;

import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.Shop;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.EnventoryItemRepository;
import com.example.icthack.repositories.InventoryRepository;
import com.example.icthack.repositories.ShopRepository;
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
    private final ShopRepository shopRepository;
    public ShopService(UserRepository userRepository, EnventoryItemRepository enventoryItemRepository, InventoryRepository inventoryRepository, ShopRepository shopRepository) {
        this.userRepository = userRepository;
        this.enventoryItemRepository = enventoryItemRepository;
        this.inventoryRepository = inventoryRepository;
        this.shopRepository = shopRepository;
    }
    public boolean buy(Trade trade){
        Inventory inv = new Inventory();
        if (userRepository.findByIsu(trade.getUserId())==null) {
            return false;
        }
        if (shopRepository.findById(trade.getItemId())==null){
            return false;
        }
        Shop shop = shopRepository.findById(trade.getItemId());
        int price = shop.getPrice();
        User buyer = userRepository.findByIsu(trade.getUserId());
        inv.setUserId(trade.getUserId());
        inv.setItemId(shop.getItemId());
        inventoryRepository.save(inv);
        buyer.setCoins(buyer.getCoins() - price);
        return true;
    }
}
