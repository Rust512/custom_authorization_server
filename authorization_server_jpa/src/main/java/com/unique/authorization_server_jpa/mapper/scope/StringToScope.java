package com.unique.authorization_server_jpa.mapper.scope;

import com.unique.authorization_server_jpa.entity.authorization_server.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StringToScope implements Function<String, Scope> {
    @Override
    public Scope apply(String stringScope) {
        return Scope.builder()
                .scopeName(stringScope)
                .build();
    }
}
