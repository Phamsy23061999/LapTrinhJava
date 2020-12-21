package com.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Borrowtickets;
import com.Entity.Employees;
import com.Repository.BorrowticketsRepository;
import com.Repository.EmployessRepository;
import com.Response.EmployeesResponse;
import com.service.EmployeesService;

import net.minidev.json.JSONObject;

@Service
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	EmployessRepository employeesRepository;
	@Autowired
	BorrowticketsRepository borrowTicketsRepository;

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
	
	@Override
	public JSONObject statistic() {
		JSONObject result = new JSONObject();
		List<Borrowtickets> allBorrowTickets = borrowTicketsRepository.getListBorrowtickets();
		List<Borrowtickets> allBorrowTicketsInYear = borrowTicketsRepository.getListBorrowticketsInYear();
		
		//Lấy số lượng phiếu mượn trong tháng
		JSONObject borrow_tickets_count_in_month = new JSONObject();
		Date now = new Date();
		List<Borrowtickets> borrow_tickets_in_month = borrowTicketsRepository.getBorrowTicketsInMonth();
		borrow_tickets_count_in_month.put("label", "res_borrow_tickets_count");
		borrow_tickets_count_in_month.put("value", borrow_tickets_in_month.size());
		result.put("borrow_tickets_count_in_month",borrow_tickets_count_in_month);
		
		//Lấy số lượng phiếu mượn theo quý trong năm
		List<JSONObject> count_quarters= new ArrayList<JSONObject>();
		for (int i = 1; i <= 4; i++) {
			JSONObject count_quarter = new JSONObject();
			int count = 0;
			count_quarter.put("quarter" , i);
			for(Borrowtickets bor : allBorrowTicketsInYear) {
				Date borrow_date = bor.getBorrow_date();
				int borrow_date_month = borrow_date.getMonth() + 1;
				System.out.print("borrow_date_month: " + borrow_date_month);
				List<Integer> months_in_quarter = new ArrayList<Integer>();
				months_in_quarter.add(i * 3);
				months_in_quarter.add(i* 3 - 1);
				months_in_quarter.add(i* 3 - 2);
				if(months_in_quarter.contains(borrow_date_month)) {
					count = count + 1;
				}
			}
			count_quarter.put("count" , count);
			count_quarters.add(count_quarter);
		}
		result.put("borrow_ticket_count_each_quarter_in_year", count_quarters);
		
		// Lấy phiếu mượn của từng tháng trong năm
		List<JSONObject>count_month = new ArrayList<JSONObject>();
		for (int i = 1; i <= 12; i++) {
			JSONObject count_months = new JSONObject();
			int count = 0;
			count_months.put("month", i);
			for(Borrowtickets bor : allBorrowTicketsInYear) {
				Date borrow_date = bor.getBorrow_date();
				int borrow_date_month = borrow_date.getMonth() + 1;
				List<Integer> month_in_year = new ArrayList<Integer>();
				month_in_year.add(i);
				
				if(month_in_year.contains(borrow_date_month)) {
					count = count + 1;
				}
			}
			count_months.put("count" , count);
			count_month.add(count_months);
		}
		result.put("borrow_ticket_count_of_each_month_in_year", count_month);
		
		// Lấy số lượng phiếu mượn trong ngày
		JSONObject borrow_tickets_count_in_day = new JSONObject();
		List<Borrowtickets> borrow_tickets_in_day = borrowTicketsRepository.getBorrowTicketsInDay();
		borrow_tickets_count_in_day.put("label", "res_borrow_tickets_count_in_day");
		borrow_tickets_count_in_day.put("value", borrow_tickets_in_day.size());
		result.put("borrow_tickets_count_in_day",borrow_tickets_count_in_day);
		return result;
	}

	@Override
	public JSONObject annualStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject quarterlyStatistics() {
		// TODO Auto-generated method stub
		return null;
	}


}
