package com.example.icthack.entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_chat')
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long chatId;

    @Column('name')
    long name;
}
