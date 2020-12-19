package com.Response;

import com.Entity.Books;

public class BookResponse {
	
	private int id;
	private String book_name;
	private int old_amount;
	private String image;
	private int page_number;
	private String author;
	private String category;
	private String description;
	
	public BookResponse() {
		
	}
	
	public BookResponse(Books books) {
		this.id=books.getId();
		this.book_name=books.getBook_name();
		this.old_amount=books.getOld_amount();
		this.image=books.getImage();
		this.author=books.getAuthor();
		this.category=books.getCategory();
		this.page_number=books.getPage_number();
		this.description=books.getDescription();
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getOld_amount() {
		return old_amount;
	}
	public void setOld_amount(int old_amount) {
		this.old_amount = old_amount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
