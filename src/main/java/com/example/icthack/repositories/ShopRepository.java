package com.example.icthack.repositories;

import com.example.icthack.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Shop findById(long id);
}
