package com.example.icthack.controllers;

import com.example.icthack.entities.Post;
import com.example.icthack.entities.User;
import com.example.icthack.responses.ShopResponse;
import com.example.icthack.responses.Trade;
import com.example.icthack.services.PostService;
import com.example.icthack.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("ItmoMeta/api/posts")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/getProfile")
    public ResponseEntity<List<Post>> getProfile(@RequestBody User user) {
        try {
            var profile = postService.getUserProfile(user.getIsu());
            return new ResponseEntity<>(profile, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getFeed")
    public ResponseEntity<List<Post>> getFeed(@RequestBody User user) {
        try {
            var feed = postService.getUserFeed(user.getIsu());
            return new ResponseEntity<>(feed, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody Post post){
        if(postService.post(post)){
            return new ResponseEntity<>("Posted successfully.", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Shit happened", HttpStatus.OK);
        }
    }
}
