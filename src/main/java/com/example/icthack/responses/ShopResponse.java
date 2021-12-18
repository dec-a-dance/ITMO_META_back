package com.example.icthack.responses;

import lombok.Data;

@Data
public class ShopResponse {
    String name;
    String imageUrl;
    long typeId;
    String type;
    String rarity;
    int price;
}
