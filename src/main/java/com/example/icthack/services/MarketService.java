package com.example.icthack.services;
import com.example.icthack.entities.*;
import com.example.icthack.repositories.*;
import com.example.icthack.responses.MarketResponse;
import com.example.icthack.responses.Sell;
import com.example.icthack.responses.ShopResponse;
import com.example.icthack.responses.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MarketService {
    private final UserRepository userRepository;
    private final InventoryRepository inventoryRepository;
    private final MarketRepository marketRepository;
    private final EnventoryItemRepository enventoryItemRepository;
    private final ItemTypeRepository itemTypeRepository;
    public MarketService(UserRepository userRepository, InventoryRepository inventoryRepository, MarketRepository marketRepository, EnventoryItemRepository enventoryItemRepository, ItemTypeRepository itemTypeRepository) {
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
        this.marketRepository = marketRepository;
        this.enventoryItemRepository = enventoryItemRepository;
        this.itemTypeRepository = itemTypeRepository;
    }
    @Transactional
    public boolean buy(Trade trade) {
        Inventory inv = new Inventory();
        if (userRepository.findByIsu(trade.getUserId()) == null) {
            return false;
        }
        Market market = marketRepository.findByItemUniqId(trade.getLotId());
        long sellerId = market.getSellerId();
        long itemUniqId = market.getItemUniqId();
        int price = market.getPrice();
        inv.setUserId(trade.getUserId());
        inv.setItemId(trade.getLotId());
        User seller = userRepository.findByIsu(sellerId);
        User buyer = userRepository.findByIsu(trade.getUserId());
        inventoryRepository.save(inv);
        inventoryRepository.removeByItemIdAndUserId(itemUniqId, sellerId);
        seller.setCoins(seller.getCoins() + price);
        buyer.setCoins(buyer.getCoins() - price);
        userRepository.save(seller);
        userRepository.save(buyer);
        marketRepository.removeByItemUniqId(trade.getLotId());
        return true;
    }

    public List<MarketResponse> getMarket(){
        List<Market> shops = marketRepository.findAll();
        List<MarketResponse> responses = new ArrayList<MarketResponse>();
        for (Market m : shops){
            EnventoryItem item = enventoryItemRepository.findById(m.getItemUniqId());
            ItemType type = itemTypeRepository.findById(item.getTypeId());
            MarketResponse resp = new MarketResponse();
            resp.setUniqId(m.getItemUniqId());
            resp.setTypeId(item.getTypeId());
            resp.setPrice(m.getPrice());
            resp.setRarity(type.getRarity());
            resp.setImageUrl(type.getImageUrl());
            resp.setType(type.getType());
            resp.setName(type.getName());
            resp.setOwnerIsu(m.getSellerId());
            responses.add(resp);
        }
        return responses;
    }

    public boolean sell(Sell sell){
        Market market = new Market();
        System.out.println(sell.getItemUniqId());
        market.setItemUniqId(sell.getItemUniqId());
        System.out.println(market.getItemUniqId());
        market.setSellerId(sell.getSellerId());
        market.setPrice(sell.getPrice());
        marketRepository.save(market);
        return true;
    }
}
