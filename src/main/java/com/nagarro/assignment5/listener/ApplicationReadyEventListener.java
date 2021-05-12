package com.nagarro.assignment5.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.nagarro.assignment5.dto.User;
import com.nagarro.assignment5.repository.UserRepository;

@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    public ApplicationReadyEventListener(BCryptPasswordEncoder encoder, UserRepository userRepository) {
	this.encoder = encoder;
	this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
	// adding dummy data 
	User user = new User();
	user.setUsername("tejas");
	user.setPassword(encoder.encode("tejas"));
	user.setRole("HR");
	user.setEnabled(false);
	userRepository.saveAndFlush(user);

	User user2 = new User();
	user2.setUsername("hr1");
	user2.setPassword(encoder.encode("password"));
	user2.setRole("HR");
	user2.setEnabled(false);
	userRepository.saveAndFlush(user2);

	User user3 = new User();
	user3.setUsername("hr2");
	user3.setPassword(encoder.encode("password"));
	user3.setRole("HR");
	user3.setEnabled(false);
	userRepository.saveAndFlush(user3);

	System.out.println("Started HR management Web App at:- http://local:8081");
    }

}
