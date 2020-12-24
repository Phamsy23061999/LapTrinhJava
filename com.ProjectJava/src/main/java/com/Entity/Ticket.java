package com.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name ="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date create_at;
	private Double fine_money;
	
	@OneToOne
    @JoinColumn(name = "borrowtickets_id")
    private Borrowtickets  borrowtickets;

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

	public Borrowtickets getBorrowtickets() {
		return borrowtickets;
	}

	public void setBorrowtickets(Borrowtickets borrowtickets) {
		this.borrowtickets = borrowtickets;
	}
	

}
