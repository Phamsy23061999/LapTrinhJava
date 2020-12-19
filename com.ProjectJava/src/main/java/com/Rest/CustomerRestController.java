package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Borrowtickets;
import com.Entity.Customers;
import com.Entity.Employees;
import com.Request.BorrowTicketsRequest;
import com.ServiceImpl.CustomerServiceIpml;
import com.service.CustomerService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/customer-management")
public class CustomerRestController {
 @Autowired
 	 CustomerService customerService;
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/create-customer")
	 public JSONObject creatCustomer(@RequestBody Customers customers) {
		 return customerService.createCustomer(customers);
	 }
	 @CrossOrigin(origins = "http://localhost:4200")	
	 @GetMapping("/get-customers")
	 public JSONObject getCustomer() {
		 return customerService.findAllCustomer();
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/update-customer")
	 public JSONObject updateCustomer(@RequestBody Customers customers) {
		 return customerService.updateCustomer(customers);
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/borrow-ticket-book")
	 public JSONObject borrowticketsBook(@RequestBody BorrowTicketsRequest borrowTicketsRequest) {
		 return customerService.borrowBook(borrowTicketsRequest);
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @PostMapping("/return-book")
	 public JSONObject returnBook(@RequestBody BorrowTicketsRequest borrowTicketsRequest) {
		 return customerService.returnBook(borrowTicketsRequest);
	 }
}
