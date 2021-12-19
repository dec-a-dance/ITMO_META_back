package com.example.icthack.controllers;

import com.example.icthack.responses.ShopResponse;
import com.example.icthack.responses.Trade;
import com.example.icthack.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/shop")
public class ShopController {
    private final ShopService shopService;
    public ShopController(ShopService shopService){
        this.shopService = shopService;
    }
    @PostMapping("/buy")
    public ResponseEntity<String> buy(@RequestBody Trade trade) {
        try {
            shopService.buy(trade);
            return new ResponseEntity<>("Purchased successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getShop")
    public ResponseEntity<List<ShopResponse>> getShop() {
        return new ResponseEntity<>(shopService.getShop(), HttpStatus.OK);
    }
}
