package com.example.icthack.repositories;

import com.example.icthack.entities.EnventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnventoryItemRepository extends JpaRepository<EnventoryItem, Long> {
    EnventoryItem findById (long id);
}
