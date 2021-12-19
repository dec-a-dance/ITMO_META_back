package com.example.icthack.controllers;

import com.example.icthack.entities.Friend;
import com.example.icthack.entities.User;
import com.example.icthack.entities.UserAchievements;
import com.example.icthack.services.AchievementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/achieve")
public class AchieveController {
    private final AchievementService achievementService;
    public AchieveController(AchievementService achievementService){
        this.achievementService = achievementService;
    }

    @PostMapping("/addAchievement")
    public ResponseEntity<String> addAchievement(@RequestBody UserAchievements achieve) {
        try {
            achievementService.addAchievementToUser(achieve);
            return new ResponseEntity<>("Friend request sent successfully.", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Something gone wrong.", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/getFriends")
    public ResponseEntity<List<Long>> getShop(@RequestBody User user) {
        return new ResponseEntity<>(achievementService.getUserAchievements(user.getIsu()), HttpStatus.OK);
    }
}
