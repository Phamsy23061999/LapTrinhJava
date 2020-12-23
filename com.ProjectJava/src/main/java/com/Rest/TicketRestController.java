package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.TicketService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/ticket-management")
public class TicketRestController {
	@Autowired
	TicketService ticketService;
	
	@GetMapping("/get-tickets")
	public JSONObject  getAllTicket() {
		return ticketService.getAllTicket();
	}
}
