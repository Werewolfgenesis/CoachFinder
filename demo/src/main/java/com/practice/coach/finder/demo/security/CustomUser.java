package com.practice.coach.finder.demo.security;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class CustomUser extends User{
	@Id 
    private String username; 
    private String password; 
	private String fullName;
	private String email;
	private String typeProfile;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.username = username;
		this.password = password;
    }
}
