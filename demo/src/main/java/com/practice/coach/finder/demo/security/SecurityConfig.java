package com.practice.coach.finder.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@RequiredArgsConstructor
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
	 private final JwtAuthFilter jwtAuthFilter;
	@Bean
    //JWT filter
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/private/api/**")
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(nullAuthProvider())
                .authorizeHttpRequests()
                .mvcMatchers("/authentication/api/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
        return http.build();
    }
	
	 @Bean
    public AuthenticationProvider nullAuthProvider() {
        return new AuthenticationManagerBeanDefinitionParser.NullAuthenticationProvider();
    }

	    


}
