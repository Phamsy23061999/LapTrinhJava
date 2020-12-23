package com.service;

import org.springframework.stereotype.Component;

import net.minidev.json.JSONObject;

@Component
public interface TicketService {
	public JSONObject getAllTicket();
}
