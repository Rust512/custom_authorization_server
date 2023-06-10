package com.unique.authorization_server_jpa.repository;

import com.unique.authorization_server_jpa.entity.authorization_server.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = """
            SELECT client
            FROM Client client
            WHERE client.clientId = :clientId
            """)
    Optional<Client> findByClientId(String clientId);
}
