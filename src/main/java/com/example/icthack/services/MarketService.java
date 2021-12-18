package com.example.icthack.services;
import com.example.icthack.entities.Inventory;
import com.example.icthack.entities.Market;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.EnventoryItemRepository;
import com.example.icthack.repositories.InventoryRepository;
import com.example.icthack.repositories.MarketRepository;
import com.example.icthack.repositories.UserRepository;
import com.example.icthack.responses.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MarketService {
    private final UserRepository userRepository;
    private final InventoryRepository inventoryRepository;
    private final MarketRepository marketRepository;

    public MarketService(UserRepository userRepository, InventoryRepository inventoryRepository, MarketRepository marketRepository) {
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
        this.marketRepository = marketRepository;
    }

    public boolean buy(Trade trade) {
        Inventory inv = new Inventory();
        if (userRepository.findByIsu(trade.getUserId()) == null) {
            return false;
        }
        Market market = marketRepository.getById(trade.getItemId());
        long seller = market.getSellerId();
        long item = market.getItemId();
        inv.setUserId(trade.getUserId());
        inv.setItemId(trade.getItemId());
        inventoryRepository.save(inv);
        inventoryRepository.deleteByItemIdAndUserId(item, seller);
        return true;
    }
}
