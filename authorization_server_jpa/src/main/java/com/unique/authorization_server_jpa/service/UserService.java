package com.unique.authorization_server_jpa.service;

import com.unique.authorization_server_jpa.exception.ResourceNotFoundException;
import com.unique.authorization_server_jpa.repository.UserRepository;
import com.unique.authorization_server_jpa.wrapper.UserWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username)
                .map(UserWrapper::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User not found", new ResourceNotFoundException("User", "username", username)
                ));
    }
}
