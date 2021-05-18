package com.nagarro.assignment5.controller;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.dto.Employee;
import com.nagarro.assignment5.service.HrManagerService;

@Controller
public class HomeController {

    private final HrManagerService hrManagerService;

    public HomeController(HrManagerService hrManagerService) {
	this.hrManagerService = hrManagerService;
    }

    // this method checks if the user is authenticated and then returns the home
    // page
    @GetMapping(value = "/home")
    public ModelAndView getHome(Map<String, Object> model) {

	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	List<Employee> employees = hrManagerService.getAllEmployeesByName(username);
	model.put("username", username);
	model.put("employees", employees);
	return new ModelAndView("home", model);
    }

}
