package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "itmo_meta_user")
public class User {
    @Id
    @Column(name = "isu_number")
    long isu;

    @Column(name = "password")
    String password;

    @Column(name = "username")
    String username;

    @Column(name = "coins")
    int coins;

    @Column(name = "diamonds")
    int diamonds;

    @Column(name = "level_points")
    int levelPoints;

    @Column(name = "skin_color")
    int skinColor;

    @Column(name="background")
    int backgroundColorId;

    @Column(name="brows")
    int browsId;

    @Column(name="eyes")
    int eyesId;

    @Column(name="hairstyle")
    int hairstyleId;

    @Column(name="mouth")
    int mouthId;

    @Column(name="pants")
    int pantsId;

    @Column(name="tshirt")
    int tShirtId;

    @Column(name="boots")
    int bootsId;

    @Column(name="glasses")
    int glassesId;
}
