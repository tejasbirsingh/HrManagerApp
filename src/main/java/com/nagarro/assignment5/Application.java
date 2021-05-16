package com.nagarro.assignment5;

import java.util.Collections;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication application = new SpringApplication(Application.class);
	// this will run the web app at 8081 port :- http://local:8081/
	application.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
	application.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(Application.class).bannerMode(Banner.Mode.OFF);
    }


}
