package com.unique.authorization_server_jpa.mapper.client;

import com.unique.authorization_server_jpa.entity.authorization_server.Client;
import com.unique.authorization_server_jpa.entity.authorization_server.RedirectURI;
import com.unique.authorization_server_jpa.entity.authorization_server.Scope;
import com.unique.authorization_server_jpa.mapper.authentication_method.AuthenticationMethodToClientAuthenticationMethod;
import com.unique.authorization_server_jpa.mapper.grant_type.GrantTypeToAuthorizationGrantType;
import com.unique.authorization_server_jpa.mapper.token_settings.ClientTokenSettingsToTokenSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ClientToRegisteredClient implements Function<Client, RegisteredClient> {

    private final GrantTypeToAuthorizationGrantType grantTypeToAuthorizationGrantType;
    private final AuthenticationMethodToClientAuthenticationMethod authMethodToClientAuthMethod;
    private final ClientTokenSettingsToTokenSettings clientTokenSettingsToTokenSettings;

    @Override
    public RegisteredClient apply(Client client) {
        return RegisteredClient.withId(Integer.toString(client.getId()))
                .clientName(client.getClientName())
                .clientId(client.getClientId())
                .clientSecret(client.getClientSecret())
                .clientAuthenticationMethods(authenticationMethods -> authenticationMethods.addAll(client.getAuthenticationMethods()
                        .stream()
                        .map(authMethodToClientAuthMethod)
                        .toList()))
                .authorizationGrantTypes(grantTypes -> grantTypes.addAll(client.getGrantTypes()
                        .stream()
                        .map(grantTypeToAuthorizationGrantType)
                        .toList()))
                .redirectUris(redirectURIs -> redirectURIs.addAll(client.getRedirectURIs()
                        .stream()
                        .map(RedirectURI::getUrl)
                        .toList()))
                .scopes(scopeSet -> scopeSet.addAll(client.getScopes()
                        .stream()
                        .map(Scope::getScopeName)
                        .toList()))
                .tokenSettings(clientTokenSettingsToTokenSettings.apply(client.getClientTokenSettings()))
                .build();
    }
}
