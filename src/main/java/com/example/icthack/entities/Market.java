package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_market")
public class Market {
    @Column(name = "price")
    int price;

    @Column(name = "seller_id")
    long sellerId;

    @Id
    @Column(name = "item_unique_id")
    long itemUniqId;
}
