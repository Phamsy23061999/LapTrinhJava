package com.Request;

public class InventoryRequest {
	private int book_id;
	private int quantity; 
	private String reason; 
	private int number_of_lost_books;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getNumber_of_lost_books() {
		return number_of_lost_books;
	}
	public void setNumber_of_lost_books(int number_of_lost_books) {
		this.number_of_lost_books = number_of_lost_books;
	}
	
}
