package com.dmm.springsecurity.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

  @Bean
  public InMemoryUserDetailsManager getUserDetailsManager() {

    UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
    UserDetails reader = User.withUsername("user").password("12345").authorities("admin").build();

    //    UserDetails admin =
    //
    // User.withDefaultPasswordEncoder().username("admin").password("12345").authorities("admin").build();
    //    UserDetails reader =
    //
    // User.withDefaultPasswordEncoder().username("user").password("12345").authorities("admin").build();
    return new InMemoryUserDetailsManager(admin, reader);
  }

  @Bean
  public PasswordEncoder getPaswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
