package com.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Borrowtickets;
import com.Entity.Ticket;
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
		TicketResponse response = new TicketResponse();
		List<TicketResponse>ticketResponse = new ArrayList<TicketResponse>();
		try {
			List<Ticket> tickets = ticketRepository.getTicket();
			for(Ticket ticket : tickets) {
				Borrowtickets borrowtickets = borrowTicketRepository.getBorrowticketById(ticket.getBorrowtickets().getId());
				BorrowticketResponse borrowticketResponse = new BorrowticketResponse(borrowtickets);
				response.setId(ticket.getId());
				response.setCreate_at(ticket.getCreate_at());
				response.setFine_money(ticket.getFine_money());
				response.setBorrowticketResponses(borrowticketResponse);
				ticketResponse.add(response);
			}
			
			data.put("is_success", true);
			data.put("ticket", ticketResponse);
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}

}
