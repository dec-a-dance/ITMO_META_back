package com.example.icthack.services;


import com.example.icthack.entities.Friend;
import com.example.icthack.entities.User;
import com.example.icthack.repositories.FriendRepository;
import com.example.icthack.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    public FriendService(FriendRepository friendRepository, UserRepository userRepository){
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    }
    public List<User> getUserFriends(long id){
        List<Friend> utilFriendList = friendRepository.findAllByWho(id);
        List<User> friends = new ArrayList<User>();
        for (Friend f: utilFriendList){
            User friend = userRepository.getById(f.getToWhom());
            friend.setPassword("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            friends.add(friend);
        }
        return friends;
    }
    public boolean sendFriendRequest(Friend friend){
        friend.setStatus(false);
        friendRepository.save(friend);
        return true;
    }
    public boolean acceptOrDeclineFriendRequest(Friend friend){
        boolean isAccepted = friend.isStatus();
        friend = friendRepository.findByWhoAndToWhom(friend.getWho(), friend.getToWhom());
        if(isAccepted){
            friend.setStatus(true);
            friendRepository.save(friend);
            Friend newFriend = new Friend();
            newFriend.setWho(friend.getToWhom());
            newFriend.setToWhom(friend.getWho());
            newFriend.setStatus(true);
            friendRepository.save(newFriend);
            return true;
        }
        else{
            friendRepository.delete(friend);
            return false;
        }
    }
}
