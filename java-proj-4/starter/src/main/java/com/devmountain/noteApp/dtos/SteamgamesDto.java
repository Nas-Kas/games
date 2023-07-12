package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Steamgames;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteamgamesDto implements Serializable {
    private Long gameId;
    private Long userId;
    private String gameName;
    private String gameGenre;
    private int numOfPlayers;
    private String platform;
    private float cost;

    public SteamgamesDto(Steamgames steamgames) {
        if (steamgames.getGameId() != null) {
            this.gameId = steamgames.getGameId();
        }
        if (steamgames.getUser() != null && steamgames.getUser().getUser_id() != null) {
            this.userId = steamgames.getUser().getUser_id();
        }
        if (steamgames.getGameName() != null) {
            this.gameName = steamgames.getGameName();
        }
        if (steamgames.getGameGenre() != null) {
            this.gameGenre = steamgames.getGameGenre();
        }
        this.numOfPlayers = steamgames.getNumOfPlayers();
        if (steamgames.getPlatform() != null) {
            this.platform = steamgames.getPlatform();
        }

        this.cost = steamgames.getCost();
    }
}
