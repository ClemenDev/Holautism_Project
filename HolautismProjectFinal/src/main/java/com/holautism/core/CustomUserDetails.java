package com.holautism.core;

import java.util.Collection;
 
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class CustomUserDetails implements UserDetails {
 
    private User user;
     
    public CustomUserDetails(User user) {
        this.user = user;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return user.getPassword();
    }
 
    @Override
    public String getUsername() {
        return user.getEmail();
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
     
    public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }
    
    public String getEmail() {
    	return user.getEmail();
    }
    
    public String getRole() {
    	return user.getRole();
    }
    
    public void setFirstName(String firstName) {
    	this.user.setFirstName(firstName);
    }
    
    public void setLastName(String LastName) {
    	this.user.setLastName(LastName);
    }
    
    public void setRole(String Role) {
    	this.user.setRole(Role);
    }
    
    public void setEmail (String Email) {
    	this.user.setEmail(Email);
    }
    
    
}