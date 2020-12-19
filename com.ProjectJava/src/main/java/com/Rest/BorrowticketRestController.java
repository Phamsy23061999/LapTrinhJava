package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Borrowtickets;
import com.Request.BorrowTicketsRequest;
import com.ServiceImpl.BorrowticketServiceImpl;
import com.service.BorrowticketService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/borrowticket-management")
public class BorrowticketRestController {
	@Autowired
	BorrowticketService borrowticketService;
	
	@GetMapping("/test")
	public String demo() {
		return "abc";
	}
	@GetMapping("/tests")
	public String demo2() {
		return "ádasd";
	}
}
