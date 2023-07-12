package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.SteamgamesDto;

import java.util.List;

public interface SteamGamesService {
    SteamgamesDto addGame(SteamgamesDto gameDto);
    SteamgamesDto updateGame(SteamgamesDto gameDto);
    void deleteGame(Long gameId);
    SteamgamesDto getGameById(Long gameId);
    List<SteamgamesDto> getAllGames();
}
