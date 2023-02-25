package com.mealkit.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2ResourceServer()
                .opaqueToken()
                .introspectionUri("http://localhost:9090/oauth2/introspect")
                .introspectionClientCredentials("client", "secret"); //TODO take parameters from db

        httpSecurity.authorizeHttpRequests()
                .anyRequest().authenticated();

        return httpSecurity.build();
    }
}
