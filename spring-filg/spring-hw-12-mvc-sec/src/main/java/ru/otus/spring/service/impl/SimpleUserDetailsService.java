package ru.otus.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.otus.spring.domain.AplUser;
import ru.otus.spring.repositories.AplUserRepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SimpleUserDetailsService implements UserDetailsService {
    private final AplUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AplUser aplUser = repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User $s not found", username)));
        return toUserDetails(aplUser);
    }

    private UserDetails toUserDetails(AplUser aplUser) {
        return new User(aplUser.getName(), aplUser.getPassword(), Collections.emptyList());
    }
}
