package com.unique.authorization_server_jpa.service;

import com.unique.authorization_server_jpa.exception.ResourceNotFoundException;
import com.unique.authorization_server_jpa.mapper.client.ClientToRegisteredClient;
import com.unique.authorization_server_jpa.mapper.client.RegisteredClientToClient;
import com.unique.authorization_server_jpa.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements RegisteredClientRepository {

    private final ClientRepository clientRepository;
    private final RegisteredClientToClient registeredClientToClient;
    private final ClientToRegisteredClient clientToRegisteredClient;

    @Override
    public void save(RegisteredClient registeredClient) {
        this.clientRepository.save(registeredClientToClient.apply(registeredClient));
    }

    @Override
    public RegisteredClient findById(String id) {
        return this.clientRepository.findById(Integer.parseInt(id))
                .map(clientToRegisteredClient)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        return this.clientRepository.findByClientId(clientId)
                .map(clientToRegisteredClient)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "clientId", clientId));
    }
}
