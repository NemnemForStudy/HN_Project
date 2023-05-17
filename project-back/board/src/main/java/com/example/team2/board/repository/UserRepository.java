package com.example.team2.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.team2.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
        public boolean existsByEmail(String email);
        public boolean existsByTelnumber(String telnumber);

        public UserEntity findByEmail(String email);
}
