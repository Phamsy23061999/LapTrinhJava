package com.Response;

import com.Entity.BorrowTicketsDetail;

import java.util.List;

public class BorrowTicketDetailResponse {
	
	private List<BorrowTicketsDetail> borrowTicketsDetails;

	public List<BorrowTicketsDetail> getBorrowTicketsDetails() {
		return this.borrowTicketsDetails;
	}

	public void setBorrowTicketsDetail(List<BorrowTicketsDetail> borrowTicketsDetails) {
		this.borrowTicketsDetails = borrowTicketsDetails;
	}
	

}
