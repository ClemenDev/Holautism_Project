package com.holautism.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("We could not find the user");
        }
        return new CustomUserDetails(user);
    }
    
    public void save (User user) {
    	userRepo.save(user);
    }
    
    public User get(Long id) {
    	return userRepo.findById(id).get();
    }
    
    public void delete (Long id) {
    	userRepo.deleteById(id);
    }
 
}