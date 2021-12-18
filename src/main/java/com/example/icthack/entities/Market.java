package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "price")
    int price;

    @Column(name = "seller_id")
    long sellerId;

    @Column(name = "item_unique_id")
    long itemUniqId;
}
