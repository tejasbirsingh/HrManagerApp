package com.nagarro.assignment5.controller;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.dto.Employee;
import com.nagarro.assignment5.service.HrManagerService;

@Controller
public class EmployeeController {

    private final HrManagerService hrManagerService;

    public EmployeeController(HrManagerService hrManagerService) {
	this.hrManagerService = hrManagerService;
    }

    @GetMapping(value = "/employee/{code}")
    public ModelAndView getEmployeeEdit(@PathVariable String code, Map<String, Object> model) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	Employee employee = hrManagerService.getEmployeeByNameAndCode(username, code);
	model.put("employee", employee);
	model.put("username", username);
	return new ModelAndView("employeeEdit", model);
    }

    @PostMapping(value = "/employee")
    public ModelAndView postEmployeeEdit(@ModelAttribute("employee") Employee employee, Map<String, Object> model) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	hrManagerService.updateEmployeeByNameAndCode(username, String.valueOf(employee.getCode()), employee);
	return new ModelAndView("redirect:/home", model);
    }

}
