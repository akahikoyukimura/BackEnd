package com.webScraping.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webScraping.demo.model.User;

@Component
public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	  private Long id;

	  private String username;

	  private String email;

	  @JsonIgnore
	  private String password;


	  
	  public CustomUserDetails() {
		super();
	}

	public CustomUserDetails(Long id, String username, String email, String password) {
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }

	  public static CustomUserDetails build(User user) {

	    return new CustomUserDetails(
	        user.getId(), 
	        user.getUsername(), 
	        user.getEmail(),
	        user.getPassword());
	  }

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return null;
	  }

	  public Long getId() {
	    return id;
	  }

	  public String getEmail() {
	    return email;
	  }

	  @Override
	  public String getPassword() {
	    return password;
	  }

	  @Override
	  public String getUsername() {
	    return username;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    CustomUserDetails user = (CustomUserDetails) o;
	    return Objects.equals(id, user.id);
	  }

}
