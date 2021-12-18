package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itmo_meta_inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="item_id")
    long itemId;

    @Column(name = "user_id")
    long userId;
}
