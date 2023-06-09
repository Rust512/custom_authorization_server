package com.unique.authorization_server_jpa.repository;

import com.unique.authorization_server_jpa.entity.credentials.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = """
            SELECT user
            FROM User user
            WHERE user.username = :username
            """)
    Optional<User> findByUsername(String username);
}
