package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.FriendsDto;

import javax.transaction.Transactional;
import java.util.List;

public interface FriendsService {
    @Transactional
    FriendsDto addFriend(FriendsDto friendsDto);
    @Transactional
    FriendsDto updateFriend(FriendsDto friendsDto);
    @Transactional
    void deleteFriend(Long friendId);
    @Transactional
    FriendsDto getFriendById(Long friendId);
    @Transactional
    List<FriendsDto> getAllFriends();

}
