package com.example.icthack.repositories;

import com.example.icthack.entities.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    List<Friend> findAllByWho(long who);
    Friend findByWhoAndToWhom(long whom, long toWhom);
}
