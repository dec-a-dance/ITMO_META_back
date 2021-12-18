package com.example.icthack.repositories;

import com.example.icthack.entities.Market;
import com.example.icthack.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorId(long id);
    List<Post> findAllByAuthorIdNot(long id);
}
