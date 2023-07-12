package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendsRepository extends JpaRepository<Friends, Long> {
}
