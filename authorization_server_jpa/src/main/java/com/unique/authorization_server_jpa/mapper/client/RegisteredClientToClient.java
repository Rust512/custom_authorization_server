package com.unique.authorization_server_jpa.mapper.client;

import com.unique.authorization_server_jpa.entity.authorization_server.Client;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RegisteredClientToClient implements Function<RegisteredClient, Client> {
    @Override
    public Client apply(RegisteredClient registeredClient) {
        return Client.builder()
                .id(Integer.parseInt(registeredClient.getId()))
                .clientId(registeredClient.getClientId())
                .clientName(registeredClient.getClientName())
                .clientSecret(registeredClient.getClientSecret())
                .build();
    }
}
