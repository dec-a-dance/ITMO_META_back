package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itmo_meta_items")
public class EnventoryItem {
    @Id
    @Column(name = "uniq_id")
    long uniqId;

    @Column(name = "type_id")
    long typeId;
}
