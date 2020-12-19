package com.Response;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.Entity.Borrowtickets;
import com.Entity.Customers;
import com.Entity.Employees;

public class BorrowticketResponse {
	
	private int id;
	
	private int quantity;
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
	
	public BorrowticketResponse() {}
	
	public BorrowticketResponse(Borrowtickets borrowtickets) {
		this.id=borrowtickets.getId();
		this.customers_name=borrowtickets.getCustomers().getFirst_name();
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
