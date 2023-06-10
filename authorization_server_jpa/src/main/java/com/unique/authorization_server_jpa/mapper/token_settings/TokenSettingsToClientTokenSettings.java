package com.unique.authorization_server_jpa.mapper.token_settings;

import com.unique.authorization_server_jpa.entity.authorization_server.ClientTokenSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TokenSettingsToClientTokenSettings implements Function<TokenSettings, ClientTokenSettings> {
    @Override
    public ClientTokenSettings apply(TokenSettings tokenSettings) {
        return ClientTokenSettings.builder()
                .tokenFormat(tokenSettings.getAccessTokenFormat().getValue())
                .timeToLiveInHours(tokenSettings.getAccessTokenTimeToLive().toHours())
                .build();
    }
}
