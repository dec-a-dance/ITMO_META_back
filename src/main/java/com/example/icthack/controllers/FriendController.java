package com.example.icthack.controllers;

import com.example.icthack.entities.Friend;
import com.example.icthack.entities.User;
import com.example.icthack.responses.MarketResponse;
import com.example.icthack.responses.Sell;
import com.example.icthack.responses.Trade;
import com.example.icthack.services.FriendService;
import com.example.icthack.services.MarketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/friend")
public class FriendController {
    private final FriendService friendService;
    public FriendController(FriendService friendService){
        this.friendService = friendService;
    }
    @PostMapping("/sendRequest")
    public ResponseEntity<String> sendRequest(@RequestBody Friend friend) {
        try {
            friendService.sendFriendRequest(friend);
            return new ResponseEntity<>("Friend request sent successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/getFriends")
    public ResponseEntity<List<User>> getShop(@RequestBody User user) {
        return new ResponseEntity<>(friendService.getUserFriends(user.getIsu()), HttpStatus.OK);
    }

    @PostMapping("/acceptOrDecline")
    public ResponseEntity<String> sell(@RequestBody Friend friend) {
        try {
            if(friendService.acceptOrDeclineFriendRequest(friend)){
                return new ResponseEntity<>("Friend added successfully.", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Friend declined successfully.", HttpStatus.OK);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
        }
    }
}
