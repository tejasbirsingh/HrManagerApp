package com.nagarro.assignment5;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
	SpringApplication application = new SpringApplication(Application.class);
	// this will run the web app at 8081 port :- http://local:8081/
	application.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
	application.run(args);
    }

}
