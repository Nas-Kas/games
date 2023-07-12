package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.FriendsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "friends")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Column(unique = true)
    private String username;

    @Column
    private String url;

    public Friends(FriendsDto friendsDto) {
        if (friendsDto.getId() != null) {
            this.id = friendsDto.getId();
        }
        if (friendsDto.getUser() != null && friendsDto.getUser().getId() != null) {
            this.user = new User();
            this.user.setUser_id(friendsDto.getUser().getId());
        }
        if (friendsDto.getUsername() != null) {
            this.username = friendsDto.getUsername();
        }
        if (friendsDto.getUrl() != null) {
            this.url = friendsDto.getUrl();
        }
    }

}
