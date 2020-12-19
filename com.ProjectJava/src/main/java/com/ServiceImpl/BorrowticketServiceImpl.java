package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Borrowtickets;
import com.Repository.BooksRepository;
import com.Repository.BorrowticketsRepository;
import com.Request.BorrowTicketsRequest;
import com.Response.BorrowticketResponse;
import com.service.BorrowticketService;

import net.minidev.json.JSONObject;

@Service
public class BorrowticketServiceImpl implements BorrowticketService{
	@Autowired
	BorrowticketsRepository borrowticketRepository;

	
}
