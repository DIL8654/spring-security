package com.dmm.springsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author dilankam date 12/09/2023
 */
@Configuration
public class SecurityConfig {

  @Bean
  @Order(SecurityProperties.BASIC_AUTH_ORDER)
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    http.securityMatcher("/**")
        .authorizeHttpRequests(
            rmr ->
                rmr.requestMatchers("/my**")
                    .authenticated()
                    .requestMatchers("/notices", "/contact")
                    .permitAll())
        .httpBasic(withDefaults())
        .formLogin(withDefaults());
    return http.build();
  }
}
