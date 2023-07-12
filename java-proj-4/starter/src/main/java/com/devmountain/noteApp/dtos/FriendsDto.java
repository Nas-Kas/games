package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Friends;
import com.devmountain.noteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendsDto implements Serializable {
    private Long id;
    private UserDto user;
    private String username;
    private String url;

    public FriendsDto(Friends friends) {
        if (friends.getId() != null) {
            this.id = friends.getId();
        }
        if (friends.getUser() != null) {
            this.user = new UserDto(friends.getUser());
        }
        if (friends.getUsername() != null) {
            this.username = friends.getUsername();
        }
        if (friends.getUrl() != null) {
            this.url = friends.getUrl();
        }
    }
}