package com.example.icthack.services;

import com.example.icthack.entities.Achieve;
import com.example.icthack.entities.UserAchievements;
import com.example.icthack.repositories.AchievementRepository;
import com.example.icthack.repositories.UserAchievementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AchievementService {
    private final AchievementRepository achievementRepository;
    private final UserAchievementRepository userAchievementRepository;
    public AchievementService(AchievementRepository achievementRepository, UserAchievementRepository userAchievementRepository){
        this.achievementRepository = achievementRepository;
        this.userAchievementRepository = userAchievementRepository;
    }
    public List<Long> getUserAchievements(long isu){
        List<UserAchievements> utilAchieveList = userAchievementRepository.findAllByUserId(isu);
        List<Long> ids = new ArrayList<Long>();
        for (UserAchievements a: utilAchieveList){
            ids.add(a.getAchieveId());
        }
        return ids;
    }
    public boolean addAchievementToUser(UserAchievements achieve){
        try{
            userAchievementRepository.save(achieve);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
