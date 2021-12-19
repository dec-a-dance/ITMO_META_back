package com.example.icthack.services;

import com.example.icthack.entities.EnventoryItem;
import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.ItemType;
import com.example.icthack.repositories.EnventoryItemRepository;
import com.example.icthack.repositories.InventoryRepository;
import com.example.icthack.repositories.ItemTypeRepository;
import com.example.icthack.responses.ItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ItemTypeRepository itemTypeRepository;
    private final EnventoryItemRepository enventoryItemRepository;
    public InventoryService(InventoryRepository inventoryRepository, ItemTypeRepository itemTypeRepository, EnventoryItemRepository enventoryItemRepository){
        this.inventoryRepository = inventoryRepository;
        this.enventoryItemRepository = enventoryItemRepository;
        this.itemTypeRepository = itemTypeRepository;
    }
    public List<ItemResponse> getUserItems(long isu){
        List<Inventory> inventory = inventoryRepository.findAllByUserId(isu);
        List<ItemResponse> items = new ArrayList<ItemResponse>();
        for (Inventory i: inventory){
            EnventoryItem itemEnt = enventoryItemRepository.findById(i.getItemId());
            ItemType type = itemTypeRepository.findById(itemEnt.getTypeId());
            ItemResponse item = new ItemResponse();
            item.setImageUrl(type.getImageUrl());
            item.setName(type.getName());
            item.setRarity(type.getRarity());
            item.setType(type.getType());
            item.setTypeId(type.getId());
            item.setUniqId(itemEnt.getUniqId());
            items.add(item);
        }
        return items;
    }
    public boolean addItemToUser(Inventory inventory){
        try {
            inventoryRepository.save(inventory);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
