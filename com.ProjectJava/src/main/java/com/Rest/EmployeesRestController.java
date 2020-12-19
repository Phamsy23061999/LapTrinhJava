package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employees;
import com.service.EmployeesService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/employee-management")
public class EmployeesRestController {
	
	@Autowired
	EmployeesService employeesService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create-employee")
	public JSONObject createEmployees(@RequestBody Employees employees) {
		return employeesService.createEmployees(employees);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get-employees")
	public JSONObject getEmployees() {
		return employeesService.findAllEmployees();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/update-employee")
	public JSONObject updateEmployees(@RequestBody Employees employees) {
		return employeesService.updateEmployees(employees);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete-employee")
	public JSONObject deleteEmployees(int id) {
		return employeesService.deleteEmployees(id);
	}
	

}
