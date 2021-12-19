package com.example.icthack.controllers;

import com.example.icthack.responses.MarketResponse;
import com.example.icthack.responses.Sell;
import com.example.icthack.responses.ShopResponse;
import com.example.icthack.responses.Trade;
import com.example.icthack.services.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/market")
public class MarketController {
    private final MarketService marketService;
    public MarketController(MarketService marketService){
        this.marketService = marketService;
    }
    @PostMapping("/buy")
    public ResponseEntity<String> buy(@RequestBody Trade trade) {
 //       try {
            marketService.buy(trade);
            return new ResponseEntity<>("Purchased successfully.", HttpStatus.OK);
 //       }
 //       catch(Exception e){
 //           return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
 //       }
    }

    @PostMapping("/getMarket")
    public ResponseEntity<List<MarketResponse>> getMarket() {
        return new ResponseEntity<>(marketService.getMarket(), HttpStatus.OK);
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sell(@RequestBody Sell sell) {
        try {
            marketService.sell(sell);
            return new ResponseEntity<>("Selled successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
        }
    }
}
