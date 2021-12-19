package com.example.icthack.repositories;

import com.example.icthack.entities.Achieve;
import com.example.icthack.entities.EnventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AchievementRepository extends JpaRepository<Achieve, Long> {
    Achieve findById (long id);
}
