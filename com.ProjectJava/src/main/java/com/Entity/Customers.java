package com.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String indentity_id;
	private String student_code;
	private String last_name;
	private String first_name;
	private String email ;
	private String phone;
	private Date birth_date;
	private String address;
	private Boolean gender;
	private String note;
	private Date delete_at;
	private Date tagdate = new Date();
	private Date expiration_date = addDays(tagdate, 30);
	
	
	@OneToMany( fetch = FetchType.LAZY, mappedBy="customers")
	private Set<Borrowtickets>borrowtickets;
	
	public Customers() {
		
	}
	
	public static Date addDays(Date d, int days)
    {
        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return d;
    }
	
	public Set<Borrowtickets> getBorrowtickets() {
		return borrowtickets;
	}


	public void setBorrowtickets(Set<Borrowtickets> borrowtickets) {
		this.borrowtickets = borrowtickets;
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


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndentity_id() {
		return indentity_id;
	}
	public void setIndentity_id(String indentity_id) {
		this.indentity_id = indentity_id;
	}
	public String getStudent_code() {
		return student_code;
	}
	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(Date delete_at) {
		this.delete_at = delete_at;
	}
	
	

}
