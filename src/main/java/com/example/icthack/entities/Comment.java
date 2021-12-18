package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_comment')
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long id;

    @Column('author_id')
    long userId;

    @Column('date_time')
    String dateTime;

    @Column('post_text')
    String postText;

}
