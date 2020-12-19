package com.service;

import org.springframework.stereotype.Component;

import com.Entity.Books;
import com.Entity.Employees;


import net.minidev.json.JSONObject;

@Component
public interface EmployeesService {
	public JSONObject createEmployees(Employees employess);
	public JSONObject findAllEmployees();
	public JSONObject updateEmployees(Employees employess);
	public JSONObject deleteEmployees(int id);

}
