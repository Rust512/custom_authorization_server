package com.unique.authorization_server_jpa.mapper.client;

import com.unique.authorization_server_jpa.entity.authorization_server.Client;
import com.unique.authorization_server_jpa.mapper.authentication_method.ClientAuthenticationMethodToAuthenticationMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class RegisteredClientToClient implements Function<RegisteredClient, Client> {

    private final ClientAuthenticationMethodToAuthenticationMethod clientAuthMethodToAuthMethod;

    @Override
    public Client apply(RegisteredClient registeredClient) {
        return Client.builder()
                .id(Integer.parseInt(registeredClient.getId()))
                .clientId(registeredClient.getClientId())
                .clientName(registeredClient.getClientName())
                .clientSecret(registeredClient.getClientSecret())
                .authenticationMethods(registeredClient.getClientAuthenticationMethods()
                        .stream()
                        .map(clientAuthMethodToAuthMethod)
                        .toList())
                .build();
    }
}
