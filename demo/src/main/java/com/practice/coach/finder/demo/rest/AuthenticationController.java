package com.practice.coach.finder.demo.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coach.finder.demo.security.CustomUser;
import com.practice.coach.finder.demo.security.JwtService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("authentication/private/api")
@RequiredArgsConstructor
public class AuthenticationController {
	 private final JwtService jwtService;
	
	   
	 @GetMapping ("/auth")
	    public void auth(@AuthenticationPrincipal CustomUser user) {
	        try {
				String token = jwtService.buildToken(user.getUsername());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	 
}
