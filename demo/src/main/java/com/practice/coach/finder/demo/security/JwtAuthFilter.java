package com.practice.coach.finder.demo.security;

import java.io.IOException;

import java.util.Collections;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final CustomUserDetailsService userService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String header = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(header) && header.startsWith("Bearer ")) {
            final String jwt = header.substring(7);
            try {
                if (!jwtService.isTokenValid(jwt)) {
                    filterChain.doFilter(request, response);
                    return;
                }
                CustomUser user;
                final String username = jwtService.extractSubject(jwt);
                if(StringUtils.endsWithAny(request.getRequestURL(),  "/auth", "/access")) {
                    user = (CustomUser) userService.loadUserDetails(new PreAuthenticatedAuthenticationToken(username, null));
                } else {
                    final String profile = jwtService.extractProfiloSelezionato(jwt);
                    List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(profile));
                    user = new CustomUser(username, "N/A", authorities);
                    user.setTypeProfile(profile);
                }
                PreAuthenticatedAuthenticationToken preAuthToken = new PreAuthenticatedAuthenticationToken(user, null, user.getAuthorities());
                preAuthToken.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(preAuthToken);
                filterChain.doFilter(request, response);
                return;
            } catch (Exception e) {
                log.error("C'è stato un problema durante la validazione del token: {}", e.getMessage());
                filterChain.doFilter(request, response);
            }
        }
        filterChain.doFilter(request, response);
    }
}
