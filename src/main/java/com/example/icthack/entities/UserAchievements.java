package com.example.icthack.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="itmo_meta_user_achievements")
public class UserAchievements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name="user_id")
    long userId;

    @Column(name="achievement_id")
    long achieveId;
}
