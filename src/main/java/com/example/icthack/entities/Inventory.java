package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_inventory')
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long id;

    @Column('item_id')
    long itemId;

    @Column('user_id')
    long userId;
}
