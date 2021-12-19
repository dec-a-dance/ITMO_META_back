package com.example.icthack.responses;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class ItemResponse {
    String imageUrl;
    long typeId;
    String name;
    String type;
    String rarity;
    long uniqId;
}
