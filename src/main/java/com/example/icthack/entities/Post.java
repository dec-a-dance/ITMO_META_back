package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table('itmo_meta_post')
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column('id')
    long id;

    @Column('author_id')
    long authorId;

    @Column('date_time')
    String dateTime;

    @Column('post_text')
    String postText;

    @Column('image_url')
    String imageUrl;

    @Column('how_many_comments')
    int howManyComments;
}
