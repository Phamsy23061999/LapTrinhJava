package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Employees;
import com.Repository.EmployessRepository;
import com.Response.EmployeesResponse;
import com.service.EmployeesService;

import net.minidev.json.JSONObject;

@Service
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	EmployessRepository employeesRepository;

	@Override
	public JSONObject createEmployees(Employees employess) {
		JSONObject data = new JSONObject();
		try {
			Employees employess2 = employeesRepository.saveAndFlush(employess);
			if(employess2 != null) {
				EmployeesResponse res = new EmployeesResponse(employess2);
				data.put("is_success",true);
				data.put("message", res);
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}

	@Override
	public JSONObject findAllEmployees() {
		JSONObject data = new JSONObject();
		try {
			List<Employees>employesses=employeesRepository.findAll();
			List<EmployeesResponse>employeesResponses = new ArrayList<EmployeesResponse>();
			if(employesses != null) {
				for(Employees employees : employesses) {
					EmployeesResponse res = new EmployeesResponse(employees);
					employeesResponses.add(res);
					data.put("is_success",true);
					data.put("message", employeesResponses);
				}
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Không Tìm Thấy Thông Tin Nhân Viên");
		}
		return data;
	}

	@Override
	public JSONObject updateEmployees(Employees employess) {
		JSONObject data = new JSONObject();
		try {
			Employees employess2 = employeesRepository.getEmployeesById(employess.getId());
			if(employess2 != null) {
				Employees employees=employeesRepository.saveAndFlush(employess);
				EmployeesResponse res = new EmployeesResponse(employees);
				data.put("is_success",true);
				data.put("message", res);
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Không Tìm Thấy Thông Tin Nhân Viên");
		}
		return data;
	}

	@Override
	public JSONObject deleteEmployees(int id) {
		JSONObject data = new JSONObject();
		try {
			int deleteEmployees = employeesRepository.deleteEmployeesByid(id);
			if(deleteEmployees != 0) {
				data.put("is_success",true);
				data.put("message", "Delete thành công");
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Không Tìm Thấy Thông Tin Nhân Viên");
		}
		return data;
	}
	
	
	

}
