package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Borrowtickets;
import com.Entity.ticket;
import com.Repository.BorrowticketsRepository;
import com.Repository.TicketRepository;
import com.Response.BorrowticketResponse;
import com.Response.TicketResponse;
import com.service.TicketService;

import net.minidev.json.JSONObject;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	BorrowticketsRepository borrowTicketRepository;

	@Override
	public JSONObject getAllTicket() {
		JSONObject data = new JSONObject();
		
		try {
			List<ticket> tickets = ticketRepository.getTickets();
			for(ticket ticket : tickets) {
				ticket.getBorrowtickets().setBorrowTicketsDetails(null);
				ticket.getBorrowtickets().getCustomers().setBorrowtickets(null);
			}
			data.put("is_success", true);
			data.put("items", tickets);
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}

}
