package com.example.icthack.services;

import com.example.icthack.entities.*;
import com.example.icthack.repositories.*;
import com.example.icthack.responses.ShopResponse;
import com.example.icthack.responses.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ShopService {
    private final UserRepository userRepository;
    private final EnventoryItemRepository enventoryItemRepository;
    private final InventoryRepository inventoryRepository;
    private final ItemTypeRepository itemTypeRepository;
    private final ShopRepository shopRepository;
    public ShopService(UserRepository userRepository, EnventoryItemRepository enventoryItemRepository, InventoryRepository inventoryRepository, ShopRepository shopRepository, ItemTypeRepository itemTypeRepository) {
        this.userRepository = userRepository;
        this.enventoryItemRepository = enventoryItemRepository;
        this.inventoryRepository = inventoryRepository;
        this.shopRepository = shopRepository;
        this.itemTypeRepository = itemTypeRepository;
    }
    public boolean buy(Trade trade){
        Inventory inv = new Inventory();
        if (userRepository.findByIsu(trade.getUserId())==null) {
            return false;
        }
        if (shopRepository.findById(trade.getLotId())==null){
            return false;
        }
        Shop shop = shopRepository.findById(trade.getLotId());
        int price = shop.getPrice();
        EnventoryItem item = new EnventoryItem();
        item.setTypeId(shop.getItemId());
        EnventoryItem newItem = enventoryItemRepository.save(item);
        User buyer = userRepository.findByIsu(trade.getUserId());
        inv.setUserId(trade.getUserId());
        inv.setItemId(newItem.getUniqId());
        inventoryRepository.save(inv);
        buyer.setCoins(buyer.getCoins() - price);
        return true;
    }
    public List<ShopResponse> getShop(){
        List<Shop> shops = shopRepository.findAll();
        List<ShopResponse> responses = new ArrayList<ShopResponse>();
        for (Shop s : shops){
            ItemType type = itemTypeRepository.findById(s.getItemId());
            ShopResponse resp = new ShopResponse();
            resp.setTypeId(type.getId());
            resp.setPrice(s.getPrice());
            resp.setRarity(type.getRarity());
            resp.setImageUrl(type.getImageUrl());
            resp.setType(type.getType());
            resp.setName(type.getName());
            responses.add(resp);
        }
        return responses;
    }
}
