package com.Response;

import java.util.Date;

import com.Entity.Employees;

public class EmployeesResponse {
	
	private int id;
	private String indentity_id;
	private String last_name;
	private String first_name;
	private String phone ;
	private String email;
	private Date birth_date;
	private String address;
	private Boolean gender;
	private String image;
	
	public EmployeesResponse() {
		
	}
	public EmployeesResponse(Employees employees) {
		this.id=employees.getId();
		this.indentity_id=employees.getIndentity_id();
		this.last_name=employees.getLast_name();
		this.first_name=employees.getFirst_name();
		this.phone=employees.getPhone();
		this.email=employees.getEmail();
		this.birth_date=employees.getBirth_date();
		this.address=employees.getAddress();
		this.gender=employees.getGender();
		this.image = employees.getImage();
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
