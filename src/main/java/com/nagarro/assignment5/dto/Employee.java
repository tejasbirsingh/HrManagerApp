package com.nagarro.assignment5.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    private long code;
    private String name;
    private String Location;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    public long getCode() {
	return code;
    }

    public void setCode(long code) {
	this.code = code;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getLocation() {
	return Location;
    }

    public void setLocation(String location) {
	Location = location;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public LocalDate getDateOfBirth() {
	return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
	return "Employee [code=" + code + ", name=" + name + ", Location=" + Location + ", email=" + email
		+ ", dateOfBirth=" + dateOfBirth + "]";
    }

}
