package com.practice.coach.finder.demo.security;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.practice.coach.finder.demo.repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken>{
	private final UserRepo repo;
	
	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
		String username = (String) token.getPrincipal();
		
		return repo.findById(username)
				.orElseThrow(EntityNotFoundException::new);
	}

}
