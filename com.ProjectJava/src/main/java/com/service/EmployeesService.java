package com.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Entity.Books;
import com.Entity.Employees;
import com.Request.BorrowTicketsRequest;

import net.minidev.json.JSONObject;

@Component
public interface EmployeesService {
	public JSONObject createEmployees(Employees employess);
	public JSONObject findAllEmployees();
	public JSONObject updateEmployees(Employees employess);
	public JSONObject deleteEmployees(int id);
	public JSONObject annualStatistics(int year);
	public JSONObject quarterlyStatistics(int quarterlyLevel);

}
