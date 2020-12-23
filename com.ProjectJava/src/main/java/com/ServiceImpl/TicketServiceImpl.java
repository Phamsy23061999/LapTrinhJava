package com.ServiceImpl;

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
			List<ticket> tickets = ticketRepository.getTicket();
			for(ticket ticket : tickets) {
				Borrowtickets borrowtickets = borrowTicketRepository.getBorrowticketById(ticket.getBorrowtickets().getId());
				BorrowticketResponse borrowticketResponse = new BorrowticketResponse(borrowtickets);
				TicketResponse response = new TicketResponse();
				response.setId(ticket.getId());
				response.setCreate_at(ticket.getCreate_at());
				response.setFine_money(ticket.getFine_money());
				response.setBorrowticketResponses(borrowticketResponse);
				data.put("is_success", true);
				data.put("ticket", response);
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}

}
