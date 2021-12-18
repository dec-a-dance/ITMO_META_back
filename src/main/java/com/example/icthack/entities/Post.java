package com.example.icthack.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "itmo_meta_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "author_id")
    long authorId;

    @Column(name = "date_time")
    String dateTime;

    @Column(name = "post_text")
    String postText;

    @Column(name = "image_url")
    String imageUrl;

    @Column(name = "how_many_comments")
    int howManyComments;
}
