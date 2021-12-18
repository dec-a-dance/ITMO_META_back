package com.example.icthack.entities;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_message')
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long messageId;

    @Nullable
    @Column('text')
    String text;

    @Column('date_time')
    String dateTime;

    @Column('sender')
    long senderId;

    @Nullable
    @Column('image')
    String imageUrl;
}
