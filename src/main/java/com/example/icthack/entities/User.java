package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table('itmo_meta_user')
public class User {
    @Id
    @Column('isu_number')
    long isu;

    @Column('password')
    String password;

    @Column('username')
    String username;

    @Column('coins')
    int coins;

    @Column('diamonds')
    int diamonds;

    @Column('level_points')
    int levelPoints;

    @Column('skin_color')

}
