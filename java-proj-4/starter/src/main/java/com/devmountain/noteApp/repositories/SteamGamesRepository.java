package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Steamgames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SteamGamesRepository extends JpaRepository<Steamgames, Long> {
}
