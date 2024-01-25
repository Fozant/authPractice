package com.fauzan.authPractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Repo.UserRepo;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    
    private final UserRepo repo;

    @Bean
    public UserDetailsService userDetailsService() {
      return username -> repo.findByEmail(username)
          .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
