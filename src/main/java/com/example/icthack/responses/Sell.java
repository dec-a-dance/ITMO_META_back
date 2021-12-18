package com.example.icthack.responses;

import com.example.icthack.entities.EnventoryItem;
import lombok.Data;

@Data
public class Sell {
    long itemUniqId;
    long sellerId;
    int price;
    String dateTime;
}
