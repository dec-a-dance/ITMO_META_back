package com.example.icthack.responses;

import lombok.Data;

@Data
public class MarketResponse {
    String name;
    long uniqId;
    String imageUrl;
    long typeId;
    String type;
    String rarity;
    int price;
}
