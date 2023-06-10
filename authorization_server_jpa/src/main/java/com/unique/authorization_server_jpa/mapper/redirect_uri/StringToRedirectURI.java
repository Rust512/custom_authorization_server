package com.unique.authorization_server_jpa.mapper.redirect_uri;

import com.unique.authorization_server_jpa.entity.authorization_server.RedirectURI;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StringToRedirectURI implements Function<String, RedirectURI> {
    @Override
    public RedirectURI apply(String stringUrl) {
        return RedirectURI.builder()
                .url(stringUrl)
                .build();
    }
}
