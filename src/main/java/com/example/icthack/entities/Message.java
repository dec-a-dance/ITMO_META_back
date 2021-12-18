package com.example.icthack.entities;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itmo_meta_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long messageId;

    @Nullable
    @Column(name = "text")
    String text;

    @Column(name = "date_time")
    String dateTime;

    @Column(name = "sender")
    long senderId;

    @Nullable
    @Column(name = "image")
    String imageUrl;

    @Column(name="chat_id")
    long chatId;
}
