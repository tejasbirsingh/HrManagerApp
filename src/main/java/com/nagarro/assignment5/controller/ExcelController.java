package com.nagarro.assignment5.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.assignment5.service.HrManagerService;

@Controller
public class ExcelController {

    private final HrManagerService hrManagerService;

    public ExcelController(HrManagerService hrManagerService) {
	this.hrManagerService = hrManagerService;
    }

    // uploads the csv data of employee to the database
    @PostMapping(value = "/excel")
    public ModelAndView postExcel(@RequestParam("file") MultipartFile file, Map<String, Object> model)
	    {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	hrManagerService.postEmployeesByNameAndFile(username, file);
	return new ModelAndView("redirect:/home", model);
    }
    
    // shows the CSV File with employee details
    @GetMapping(value = "/excel")
    public void getExcel(HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String username = auth.getName();
	hrManagerService.sendXmlToUserByName(username, response);
    }
}
