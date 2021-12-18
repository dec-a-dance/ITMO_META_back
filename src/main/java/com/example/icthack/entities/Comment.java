package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "author_id")
    long userId;

    @Column(name="date_time")
    String dateTime;

    @Column(name = "post_text")
    String postText;

}
