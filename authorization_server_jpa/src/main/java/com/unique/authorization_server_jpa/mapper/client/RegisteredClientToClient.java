package com.unique.authorization_server_jpa.mapper.client;

import com.unique.authorization_server_jpa.entity.authorization_server.Client;
import com.unique.authorization_server_jpa.mapper.authentication_method.ClientAuthenticationMethodToAuthenticationMethod;
import com.unique.authorization_server_jpa.mapper.grant_type.AuthorizationGrantTypeToGrantType;
import com.unique.authorization_server_jpa.mapper.redirect_uri.StringToRedirectURI;
import com.unique.authorization_server_jpa.mapper.scope.StringToScope;
import com.unique.authorization_server_jpa.mapper.token_settings.TokenSettingsToClientTokenSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class RegisteredClientToClient implements Function<RegisteredClient, Client> {

    private final ClientAuthenticationMethodToAuthenticationMethod clientAuthMethodToAuthMethod;
    private final AuthorizationGrantTypeToGrantType authorizationGrantTypeToGrantType;
    private final StringToScope stringToScope;
    private final StringToRedirectURI stringToRedirectURI;
    private final TokenSettingsToClientTokenSettings tokenSettingsToClientTokenSettings;

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
                .grantTypes(registeredClient.getAuthorizationGrantTypes()
                        .stream()
                        .map(authorizationGrantTypeToGrantType)
                        .toList())
                .scopes(registeredClient.getScopes()
                        .stream()
                        .map(stringToScope)
                        .toList())
                .redirectURIs(registeredClient.getRedirectUris()
                        .stream()
                        .map(stringToRedirectURI)
                        .toList())
                .clientTokenSettings(tokenSettingsToClientTokenSettings.apply(registeredClient.getTokenSettings()))
                .build();
    }
}
