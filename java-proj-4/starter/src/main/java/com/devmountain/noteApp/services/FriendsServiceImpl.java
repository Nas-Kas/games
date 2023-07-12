package com.devmountain.noteApp.services;
import com.devmountain.noteApp.dtos.FriendsDto;
import com.devmountain.noteApp.entities.Friends;
import com.devmountain.noteApp.repositories.FriendsRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public FriendsDto addFriend(FriendsDto friendDto) {
        Friends friend = new Friends(friendDto);
        BeanUtils.copyProperties(friendDto, friend, "id");
        Friends savedFriend = friendsRepository.save(friend);
        return new FriendsDto(savedFriend);
    }

    @Override
    public FriendsDto updateFriend(FriendsDto friendDto) {
        Optional<Friends> optionalFriend = friendsRepository.findById(friendDto.getId());
        if (optionalFriend.isPresent()) {
            Friends friend = optionalFriend.get();
            BeanUtils.copyProperties(friendDto, friend, "id");
            Friends updatedFriend = friendsRepository.save(friend);
            return new FriendsDto(updatedFriend);
        }
        return null;
    }

    @Override
    public void deleteFriend(Long friendId) {
        friendsRepository.deleteById(friendId);
    }

    @Override
    public FriendsDto getFriendById(Long friendId) {
        Optional<Friends> optionalFriend = friendsRepository.findById(friendId);
        return optionalFriend.map(FriendsDto::new).orElse(null);
    }

    @Override
    public List<FriendsDto> getAllFriends() {
        List<Friends> friends = friendsRepository.findAll();
        return friends.stream().map(FriendsDto::new).collect(Collectors.toList());
    }

}
