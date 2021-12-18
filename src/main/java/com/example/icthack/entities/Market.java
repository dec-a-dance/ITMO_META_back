package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_market')
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long id;

    @Column('item_id')
    long itemId;

    @Column('price')
    int price;

    @Column('seller_id')
    long sellerId;
}
