package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_items')
public class EnventoryItem {
    @Column('image')
    String imageUrl;

    @Column('uniq_id')
    long uniqId;

    @Column('id')
    long id;

    @Column('type')
    String type;

    @Column('rarity')
    String rarity;

    @Column('price')
    int price;
}
