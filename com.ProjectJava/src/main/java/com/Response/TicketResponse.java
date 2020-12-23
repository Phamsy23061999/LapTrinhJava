package com.Response;

import java.util.Date;
import java.util.List;

public class TicketResponse {
	
	private int id;
	private Date create_at;
	private Double fine_money;
	private BorrowticketResponse borrowticket;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Double getFine_money() {
		return fine_money;
	}
	public void setFine_money(Double fine_money) {
		this.fine_money = fine_money;
	}
	public BorrowticketResponse getBorrowticketResponses() {
		return borrowticket;
	}
	public void setBorrowticketResponses(BorrowticketResponse borrowticketResponses) {
		this.borrowticket = borrowticketResponses;
	}

	

}
