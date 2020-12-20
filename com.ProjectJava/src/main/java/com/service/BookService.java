package com.service;

import org.springframework.stereotype.Component;

import com.Entity.Books;
import com.Request.BookRequest;

import net.minidev.json.JSONObject;

@Component
public interface BookService {
	
	public JSONObject createBook(Books books);
	public JSONObject updateBooks(BookRequest bookRequest);
	public JSONObject findAllBook();
	public JSONObject deleteBook(int id);
	public JSONObject getBookByIdAndBookName(BookRequest bookRequest);
	public JSONObject searchBooksByKeywords(Books book);
}
