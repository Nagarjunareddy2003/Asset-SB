package com.Vcube.Asserts.SB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.Asserts.SB.modal.Employee;
import com.Vcube.Asserts.SB.service.AssetService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	AssetService assetservice;
	@PostMapping("/insertemp")
	public Employee insertemp(@RequestBody Employee employee) {
		return assetservice.addEmployee(employee);
	}
	
	@GetMapping("/getallemp")
	public List<Employee> getallemp(){
		return assetservice.allemployee();
	}

}
