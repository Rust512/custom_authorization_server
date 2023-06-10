package com.unique.authorization_server_jpa.mapper.grant_type;

import com.unique.authorization_server_jpa.entity.authorization_server.GrantType;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GrantTypeToAuthorizationGrantType implements Function<GrantType, AuthorizationGrantType> {
    @Override
    public AuthorizationGrantType apply(GrantType grantType) {
        return new AuthorizationGrantType(grantType.getGrantTypeName());
    }
}
