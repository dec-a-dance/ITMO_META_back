package com.example.icthack.repositories;

import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findAllByUserId(long userId);
}
