package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Friends;
import com.devmountain.noteApp.entities.Steamgames;
import com.devmountain.noteApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String password;
    private List<Friends> friendsList;
    private List<Steamgames> steamGamesList;

    public UserDto(User user){
        if(user.getUser_id() != null){
            this.id = user.getUser_id();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
        if(user.getFriendsList() != null){
            this.friendsList = user.getFriendsList();
        }
        if(user.getSteamGamesList() != null){
            this.steamGamesList = user.getSteamGamesList();
        }
    }

}
