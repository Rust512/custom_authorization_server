package com.unique.authorization_server_jpa.wrapper;

import com.unique.authorization_server_jpa.entity.credentials.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class AuthorityWrapper implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getAuthorityName();
    }
}
