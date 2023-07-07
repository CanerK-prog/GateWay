package com.mealkit.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@Configuration
@EnableWebFlux
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity security){

        security.csrf()
                .disable()
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/eureka/**")
                        .permitAll()
                        .anyExchange()
                        .authenticated())
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

        return security.build();
    }
}
