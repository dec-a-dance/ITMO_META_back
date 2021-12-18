package com.example.icthack.entities;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long chatId;

    @Column(name="name")
    long name;
}
