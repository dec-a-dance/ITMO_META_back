package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

    @Data
    @Entity
    @Table(name = "itmo_meta_item_type")
    public class ItemType {
        @Column(name="image")
        String imageUrl;

        @Id
        @Column(name="id")
        long id;

        @Column(name="name")
        String name;

        @Column(name = "type")
        String type;

        @Column(name="rarity")
        String rarity;
}
