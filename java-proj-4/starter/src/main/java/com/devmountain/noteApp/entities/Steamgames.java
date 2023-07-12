package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.SteamgamesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "steamgames")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Steamgames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String gameName;

    @Column
    private String gameGenre;

    @Column
    private int numOfPlayers;

    @Column
    private String platform;

    @Column
    private float cost;

    public Steamgames(SteamgamesDto steamgamesDto) {
        if (steamgamesDto.getGameId() != null) {
            this.gameId = steamgamesDto.getGameId();
        }
        if (steamgamesDto.getUserId() != null) {
            this.user.setUser_id(steamgamesDto.getUserId());
        }
        if (steamgamesDto.getGameName() != null) {
            this.gameName = steamgamesDto.getGameName();
        }
        if (steamgamesDto.getGameGenre() != null) {
            this.gameGenre = steamgamesDto.getGameGenre();
        }
        this.numOfPlayers = steamgamesDto.getNumOfPlayers();
        if (steamgamesDto.getPlatform() != null) {
            this.platform = steamgamesDto.getPlatform();
        }
        this.cost = steamgamesDto.getCost();
    }

}
