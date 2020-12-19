package com.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Books;
import com.Request.BookRequest;
import com.ServiceImpl.BookServiceImpl;
import com.service.BookService;

import net.minidev.json.JSONObject;

@RestController
@RequestMapping("/admin/book-management")
public class BookRestController {
	@Autowired
	BookService bookService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/create-book")
	public JSONObject createBook(@RequestBody Books book) {
		return  bookService.createBook(book);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get-books")
	public JSONObject getBook() {
		return  bookService.findAllBook();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get-books-by-id-and-book-name")
	public JSONObject getBookByIdAndBookName(BookRequest bookRequest) {
		return  bookService.getBookByIdAndBookName(bookRequest);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/update-book")
	public JSONObject updateBook(@RequestBody BookRequest bookRequest) {
		return  bookService.updateBooks(bookRequest);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete-book")
	public JSONObject deleteBook(int id) {
		return   bookService.deleteBook(id);
	}

}
