package com.unique.authorization_server_jpa.mapper.authentication_method;

import com.unique.authorization_server_jpa.entity.authorization_server.AuthenticationMethod;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientAuthenticationMethodToAuthenticationMethod
        implements Function<ClientAuthenticationMethod, AuthenticationMethod> {
    @Override
    public AuthenticationMethod apply(ClientAuthenticationMethod clientAuthenticationMethod) {
        return AuthenticationMethod.builder()
                .authenticationMethodName(clientAuthenticationMethod.getValue())
                .build();
    }
}
