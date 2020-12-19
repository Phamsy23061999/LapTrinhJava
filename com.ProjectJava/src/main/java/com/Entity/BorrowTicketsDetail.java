package com.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import net.bytebuddy.asm.Advice.Return;

@Entity
@Table(name="borrowticketsDetail")
public class BorrowTicketsDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date delete_at;	
	
	@ManyToOne
	@JoinColumn(name="borrowtickets_id", nullable=false)
	private Borrowtickets borrowtickets;
	
	@ManyToOne
	@JoinColumn(name="books",nullable=false)
	private Books books;
	
	public BorrowTicketsDetail() {
		
	}
	
	public Date getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(Date delete_at) {
		this.delete_at = delete_at;
	}
	public Borrowtickets getBorrowtickets() {
		return borrowtickets;
	}
	public void setBorrowtickets(Borrowtickets borrowtickets) {
		this.borrowtickets = borrowtickets;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
