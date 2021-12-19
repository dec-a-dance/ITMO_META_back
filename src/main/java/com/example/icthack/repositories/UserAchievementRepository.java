package com.example.icthack.repositories;

import com.example.icthack.entities.Achieve;
import com.example.icthack.entities.UserAchievements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAchievementRepository extends JpaRepository<UserAchievements, Long> {
    List<UserAchievements> findAllByUserId (long isu);
}
