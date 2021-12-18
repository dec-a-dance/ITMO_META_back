package com.example.icthack.repositories;

import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
    ItemType findById(long id);
}
