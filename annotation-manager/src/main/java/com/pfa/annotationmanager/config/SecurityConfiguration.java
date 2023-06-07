package com.pfa.annotationmanager.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.pfa.annotationmanager.user.Permission.*;

import static com.pfa.annotationmanager.user.Permission.*;
import static com.pfa.annotationmanager.user.Role.ADMIN;
import static com.pfa.annotationmanager.user.Role.EXPERT;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
            .cors().and()
        .authorizeHttpRequests()
        .requestMatchers(
                "/auth/**",
                "/v3/api-docs",
                "/v3/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger-ui.html"
        )
          .permitAll()




        .requestMatchers("/admin/**").hasRole(ADMIN.name())

        .requestMatchers(GET, "/admin/**").hasAuthority(ADMIN_READ.name())
        .requestMatchers(POST, "/admin/**").hasAuthority(ADMIN_CREATE.name())
        .requestMatchers(PUT, "/admin/**").hasAuthority(ADMIN_UPDATE.name())
        .requestMatchers(DELETE, "/admin/**").hasAuthority(ADMIN_DELETE.name())

            .requestMatchers("/expert/**").hasRole(EXPERT.name())
            .requestMatchers(GET, "/expert/**").hasAuthority(EXPERT_READ.name())
            .requestMatchers(POST, "/expert/**").hasAuthority(EXPERT_CREATE.name())
            .requestMatchers(PUT, "/expert/**").hasAuthority(EXPERT_UPDATE.name())
            .requestMatchers(DELETE, "/expert/**").hasAuthority(EXPERT_DELETE.name())


        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//        .logout()
//        .logoutUrl("/api/v1/auth/logout")
//        .addLogoutHandler(logoutHandler)
//        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}
