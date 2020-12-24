package com.Response;

import com.Entity.Books;
import com.Entity.Inventory;

public class InventoryResponse {
	
	private int id;
	private String reason;
	private int quantity;
	
	private Books books;
	
	public InventoryResponse() {
		
	}
	public InventoryResponse(Inventory inventory) {
		this.id = inventory.getId();
		this.reason = inventory.getReason();
		this.quantity = inventory.getQuantity();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	
	
}
