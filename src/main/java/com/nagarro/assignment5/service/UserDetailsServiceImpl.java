package com.nagarro.assignment5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nagarro.assignment5.dto.MyUserDetails;
import com.nagarro.assignment5.dto.User;
import com.nagarro.assignment5.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepository.getUserByUsername(username);
	if (user == null) {
	    throw new UsernameNotFoundException("User not found!");
	}
	return new MyUserDetails(user);
    }

}
