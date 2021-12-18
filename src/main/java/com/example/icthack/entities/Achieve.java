package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itmo_meta_achieve")
public class Achieve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "id")
    long id;

    @Column(name =  "title")
    String title;

    @Column(name = "text")
    String text;

    @Column(name = "image")
    String imageUrl;
}
