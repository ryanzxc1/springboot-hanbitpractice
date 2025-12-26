package com.example.bd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // POST 테스트를 위해 보통 같이 끕니다
                .authorizeHttpRequests(auth -> auth
                        // 1. 특정 경로를 완전 허용하고 싶은 경우
                        .requestMatchers("/members/**").permitAll()
                        // 2. 또는 모든 GET 요청을 허용하고 싶은 경우
                        // .requestMatchers(HttpMethod.GET, "/**").permitAll()
                        .anyRequest().authenticated() // 그 외는 인증 필요
                );

        return http.build();
    }
}