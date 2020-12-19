package com.ServiceImpl;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Books;
import com.Repository.BooksRepository;
import com.Request.BookRequest;
import com.Response.BookResponse;
import com.service.BookService;


import net.minidev.json.JSONObject;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	BooksRepository bookRepository;

	@Override
	public JSONObject createBook(Books book) {
		JSONObject data = new JSONObject();
		try {
			Books books = bookRepository.saveAndFlush(book);
			if(books != null) {
				BookResponse res= new BookResponse(books);
				data.put("save_book", res);	
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Error","Lưu Không Thành Công");
		}
		return data;
	}

	@Override
	public JSONObject updateBooks(BookRequest bookRequest) {
		JSONObject data = new JSONObject();
		try {
			Books books = bookRepository.getBookById(bookRequest.getId());
			if(books != null) {
				int updateBook = bookRepository.updateBook(bookRequest.getBook_name(),bookRequest.getDescription(),bookRequest.getImage()
						,bookRequest.getPage_number() ,bookRequest.getOld_amount(),bookRequest.getId());
				if(updateBook != 0) {
					data.put("is_success", true);
					data.put("message", "Update thành công");
				}
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr","update Không thành công");
		}
		return data;
	}

	@Override
	public JSONObject findAllBook() {
		JSONObject data = new JSONObject();
		try {
			List<Books> books = bookRepository.findAll();
			List<BookResponse>bookResponses = new ArrayList<BookResponse>();
			if(books != null) {
				for(Books books2 : books) {
					BookResponse res = new BookResponse(books2);
					bookResponses.add(res);
					data.put("items", bookResponses);
				}	
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}

	@Override
	public JSONObject deleteBook(int id) {
		JSONObject data = new JSONObject();
		try {
			int deleteBook = bookRepository.deleteBook(id);
			if(deleteBook!=0) {
				data.put("is_success", true);
				data.put("message", "Delete thành công");
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Không tìm thấy thông tin sách");
		}
		return data;
	}

	@Override
	public JSONObject getBookByIdAndBookName(BookRequest bookRequest) {
		JSONObject data = new JSONObject();
		try {
			List<BookResponse>bookResponses = new ArrayList<>();
			Books books = new Books();
			
			books =  bookRepository.getBookById(bookRequest.getId());
			if(books==null) {
				data.put("message", "Tìm kiếm sách theo id thất bại");
			}
			BookResponse res = new BookResponse(books);
			bookResponses.add(res);
			books = bookRepository.getBookByBookName(bookRequest.getBook_name());
			if(books == null ) {
				data.put("message", "Tìm kiếm Sách thất bại");
			}
			BookResponse response = new BookResponse(books);
			bookResponses.add(response);
			data.put("is_success", true);
			data.put("message", bookResponses);
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Không tìm kiếm thấy sách");
		}
		return data;
	}

	
	
	

}
