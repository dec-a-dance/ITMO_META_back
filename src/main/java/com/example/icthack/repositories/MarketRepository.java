package com.example.icthack.repositories;

import com.example.icthack.entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {
    Market findByItemUniqId(long id);
    void removeByItemUniqId(long id);
}
