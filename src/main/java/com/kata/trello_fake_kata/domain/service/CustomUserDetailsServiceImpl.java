package com.kata.trello_fake_kata.domain.service;
import com.kata.trello_fake_kata.domain.model.User;
import com.kata.trello_fake_kata.infraestructure.persistence.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = Logger.getLogger(CustomUserDetailsServiceImpl.class.getName());
    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email) // Busca por email
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));
        logger.info("Usuario: " + user);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
