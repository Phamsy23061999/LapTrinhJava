package com.Request;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.Entity.BorrowTicketsDetail;

public class BorrowTicketsRequest {
	
	private int id;
	private int quantity;
	private Date tagdate;
	private Date expiration_date;
	
	private Date borrow_date;
	private Date appointment_date;
	private Date return_date;
	private Boolean status;
	private Date delete_at;
	private String note;
	private int employess_id;
	private int customers_id;
	private String employess_name;
	private String customers_name;
	private  List<Integer> book_ids;
	
	
	
	
	
	public List<Integer> getBook_ids() {
		return book_ids;
	}
	public void setBook_ids(List<Integer> book_ids) {
		this.book_ids = book_ids;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getTagdate() {
		return tagdate;
	}
	public void setTagdate(Date tagdate) {
		this.tagdate = tagdate;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Date getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(Date delete_at) {
		this.delete_at = delete_at;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getEmployess_id() {
		return employess_id;
	}
	public void setEmployess_id(int employess_id) {
		this.employess_id = employess_id;
	}
	public int getCustomers_id() {
		return customers_id;
	}
	public void setCustomers_id(int customers_id) {
		this.customers_id = customers_id;
	}
	public String getEmployess_name() {
		return employess_name;
	}
	public void setEmployess_name(String employess_name) {
		this.employess_name = employess_name;
	}
	public String getCustomers_name() {
		return customers_name;
	}
	public void setCustomers_name(String customers_name) {
		this.customers_name = customers_name;
	}
	
	

}
