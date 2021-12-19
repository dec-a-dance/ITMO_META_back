package com.example.icthack.services;

import com.example.icthack.entities.Post;
import com.example.icthack.repositories.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {
    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    public List<Post> getUserProfile(long id){
        return postRepository.findAllByAuthorId(id);
    }
    public List<Post> getUserFeed(long id){
        return postRepository.findAllByAuthorIdNot(id);
    }
    public boolean post(Post post){
        try {
            postRepository.save(post);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
