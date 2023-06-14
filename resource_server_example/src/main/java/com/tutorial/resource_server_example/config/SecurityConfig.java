package com.tutorial.resource_server_example.config;

import com.tutorial.resource_server_example.converter.CustomJwtAuthenticationTokenConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Resource server configuration
        http.oauth2ResourceServer(
                resourceServer -> resourceServer.jwt(
                        jwtConfig -> jwtConfig.jwkSetUri("http://localhost:8080/oauth2/jwks")
                                .jwtAuthenticationConverter(new CustomJwtAuthenticationTokenConverter())
                )
        );

        // Authorization rules
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        return http.build();
    }
}
