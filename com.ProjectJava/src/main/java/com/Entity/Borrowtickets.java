package com.Entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.Repository.EmployessRepository;

@Entity
@Table(name="borrowtickets")
public class Borrowtickets {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private int quantity;
	private Date borrow_date;
	private Date appointment_date;
	private Date return_date;
	private Boolean status;
	private Date delete_at;
	private String note;
	
	@ManyToOne
	@JoinColumn(name="employees_id",nullable=false)
	private Employees employess;
	
	@ManyToOne
	@JoinColumn(name="customers_id",nullable=false)
	private Customers customers;
	
	@OneToMany(mappedBy="borrowtickets")
	private  List<BorrowTicketsDetail> borrowTicketsDetails ;
	
	


	public Borrowtickets() {
		
	}
	
	public Customers getCustomers() {
		return customers;
	}
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}
	public List<BorrowTicketsDetail> getBorrowTicketsDetails() {
		return this.borrowTicketsDetails;
	}
	public void setBorrowTicketsDetails(List<BorrowTicketsDetail> borrowTicketsDetails) {
		this.borrowTicketsDetails = borrowTicketsDetails;
	}
	public Employees getEmployess() {
		return employess;
	}
	public void setEmployess(Employees employess) {
		this.employess = employess;
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
	
	
	

}
