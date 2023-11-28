package com.my_bank.myBank.domain.user.repository;

import com.my_bank.myBank.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findByUserId(Long userId);
    List<User> findAll();
    Optional<User> findByLoginId(String name);
}
