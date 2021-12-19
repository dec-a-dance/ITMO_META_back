package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="who")
    long who;

    @Column(name="to_whom")
    long toWhom;

    @Column(name="status")
    boolean status;
}
