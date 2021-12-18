package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_achieve')
public class Achieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long id;

    @Column('title')
    String title;

    @Column('text')
    String text;

    @Column('image')
    String imageUrl;
}
