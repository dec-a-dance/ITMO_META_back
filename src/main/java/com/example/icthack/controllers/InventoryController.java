package com.example.icthack.controllers;

import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.User;
import com.example.icthack.responses.ItemResponse;
import com.example.icthack.services.FriendService;
import com.example.icthack.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    @GetMapping("/getInventory")
    public ResponseEntity<List<ItemResponse>> getInventory(@RequestBody User user){
        return new ResponseEntity<>(inventoryService.getUserItems(user.getIsu()), HttpStatus.OK);
    }
    @PostMapping("/addItem")
    public ResponseEntity<String> addItem(@RequestBody Inventory inventory){
        try {
            inventoryService.addItemToUser(inventory);
            return new ResponseEntity<>("Item added successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Shit happened.", HttpStatus.BAD_REQUEST);
        }
    }
}
