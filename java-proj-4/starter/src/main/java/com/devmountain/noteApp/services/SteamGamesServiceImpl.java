package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.SteamgamesDto;
import com.devmountain.noteApp.entities.Steamgames;
import com.devmountain.noteApp.repositories.SteamGamesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SteamGamesServiceImpl implements SteamGamesService {
    @Autowired
    private SteamGamesRepository steamGamesRepository;

    @Autowired
    public SteamGamesServiceImpl(SteamGamesRepository steamGamesRepository) {
        this.steamGamesRepository = steamGamesRepository;
    }

    @Override
    public SteamgamesDto addGame(SteamgamesDto gameDto) {
        Steamgames game = new Steamgames(gameDto);
        BeanUtils.copyProperties(gameDto, game);
        Steamgames savedGame = steamGamesRepository.save(game);
        return new SteamgamesDto(savedGame);
    }

    @Override
    public SteamgamesDto updateGame(SteamgamesDto gameDto) {
        Optional<Steamgames> optionalGame = steamGamesRepository.findById(gameDto.getGameId());
        if (optionalGame.isPresent()) {
            Steamgames game = optionalGame.get();
            BeanUtils.copyProperties(gameDto, game, "gameId", "userId");
            Steamgames updatedGame = steamGamesRepository.save(game);
            return new SteamgamesDto(updatedGame);
        }
        return null;
    }

    @Override
    public void deleteGame(Long gameId) {
        steamGamesRepository.deleteById(gameId);
    }

    @Override
    public SteamgamesDto getGameById(Long gameId) {
        Optional<Steamgames> optionalGame = steamGamesRepository.findById(gameId);
        return optionalGame.map(SteamgamesDto::new).orElse(null);
    }

    @Override
    public List<SteamgamesDto> getAllGames() {
        List<Steamgames> games = steamGamesRepository.findAll();
        return games.stream().map(SteamgamesDto::new).collect(Collectors.toList());
    }
}
