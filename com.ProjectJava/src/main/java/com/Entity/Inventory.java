package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reason;
	private int quantity;
	private int number_of_lost_books;
	
	
	@OneToOne
    @JoinColumn(name = "books_id")
    private Books books;


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


	public int getNumber_of_lost_books() {
		return number_of_lost_books;
	}


	public void setNumber_of_lost_books(int number_of_lost_books) {
		this.number_of_lost_books = number_of_lost_books;
	}
	
	
}
