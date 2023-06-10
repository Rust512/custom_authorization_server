package com.unique.authorization_server_jpa.service;

import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

public class ClientService implements RegisteredClientRepository {
    @Override
    public void save(RegisteredClient registeredClient) {
        // TODO: implement the mapper
    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return null;
    }
}
