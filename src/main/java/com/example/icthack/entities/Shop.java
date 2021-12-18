package com.example.icthack.entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "item_id")
    long itemId;

    @Column(name = "price")
    int price;
}
