package com.ServiceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Books;
import com.Entity.BorrowTicketsDetail;
import com.Entity.Borrowtickets;
import com.Entity.Customers;
import com.Entity.Employees;
import com.Repository.BooksRepository;
import com.Repository.BorrowticketDetailRepository;
import com.Repository.BorrowticketsRepository;
import com.Repository.CustomersRepository;
import com.Repository.EmployessRepository;
import com.Repository.TicketRepository;
import com.Request.BorrowTicketsRequest;
import com.Response.CustomerResponse;
import com.service.CustomerService;

import net.minidev.json.JSONObject;

@Service
public class CustomerServiceIpml implements CustomerService{
	@Autowired
	CustomersRepository customerRepository;
	@Autowired
	EmployessRepository employessRepository;
	@Autowired
	BorrowticketsRepository borrowticketsRepository;
	@Autowired
	BorrowticketDetailRepository borrowticketDetailRepository;
	@Autowired
	BooksRepository bookRepository;
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public JSONObject createCustomer(Customers customers) {
		JSONObject data = new JSONObject();
		try {
			Customers customers2 = customerRepository.saveAndFlush(customers);
			if(customers2 != null) {
				CustomerResponse customerResponse = new CustomerResponse(customers2);
				data.put("message",customerResponse );	
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr","update Không thành công");
		}
		return data;
	}

	@Override
	public JSONObject findAllCustomer() {
		JSONObject data = new JSONObject();
		try {
			List<Customers> customers = customerRepository.findAll();
			List<CustomerResponse> customerResponses=new ArrayList<CustomerResponse>();
			if(customers != null) {
				for(Customers customers2 :customers) {
					CustomerResponse customerResponse= new CustomerResponse(customers2);
					customerResponses.add(customerResponse);
					data.put("items", customerResponses);
					
				}
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}

	@Override
	public JSONObject updateCustomer(Customers customer) {
		JSONObject data = new JSONObject();
		try {
			Customers customers = new Customers();
			customers = customerRepository.getCustomersById(customer.getId());
			if(customers != null) {
				Customers customer2=customerRepository.save(customer);
				if(customer2 != null) {
					data.put("is_success", true);
					data.put("message", "Update thành công");
				}
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}
	
	public boolean checkBorrowingCustomer(Customers customer) {	
		return borrowticketsRepository.checkBorrowingCustomer(customer.getId()).size() > 0;
	}
	
	@Override
	public JSONObject borrowBook(BorrowTicketsRequest borrowtickets) {
 		JSONObject data = new JSONObject();
//		Borrowtickets  borrowtickets2 = new Borrowtickets();
//		borrowtickets2.setBorrow_date(new Date());
//		borrowtickets2.setAppointment_date(addDays(new Date(), 20));
//		borrowtickets2.setCustomers(customers);
 		Borrowtickets  borrowtickets2 = new Borrowtickets();
		try {
			Employees employees2 = employessRepository.getEmployeesById(borrowtickets.getEmployess_id());
			if(employees2 != null) {
				 Customers customers = customerRepository.getCustomersById(borrowtickets.getCustomers_id());
				 if(checkBorrowingCustomer(customers)) {
					 data.put("is_success", false);
					 data.put("message", "Khach hàng này đang mượn 1 phiếu mượn khác.");
					 return data;
				 }
				 if(customers != null) {
					 		Date appointment = new Date();
							Date tagDate = customers.getTagdate();
							Date expirationDate = customers.getExpiration_date();
							Date appointment_date = addDays(appointment, 20);
							Date borrow_date =new Date();  // now
							long millisTag = tagDate.getTime();
							long millisAppointment = appointment_date.getTime();
							long miliBorrowDate = borrow_date.getTime();
							long miilisExpiration =expirationDate.getTime();
							int date = (int)((miilisExpiration- millisTag)/(1000*60*60*24));
							int borrowDate =(int)((millisAppointment - miliBorrowDate)/(1000*60*60*24));
		
							borrowtickets2.setBorrow_date(new Date());
							borrowtickets2.setAppointment_date(addDays(new Date(), 30));
							borrowtickets2.setQuantity(borrowtickets.getBook_ids().size());
							borrowtickets2.setCustomers(customers);
							borrowtickets2.setEmployess(employees2);
							borrowtickets2 = borrowticketsRepository.save(borrowtickets2);
							
							if( borrowDate <=30 && date <=365){
								for(int book_id: borrowtickets.getBook_ids()){
									int borrowticketDetail = borrowticketDetailRepository.createBorrowticketDetail(book_id, borrowtickets2.getId());
									Books book = bookRepository.getBookById(book_id);
									book.setOld_amount(book.getOld_amount() - 1);
									int update_book = bookRepository.updateBookById(book.getOld_amount() - 1, book_id);
								}	
								data.put("is_success", true);
								data.put("messge","Tao Thanh Cong Phieu Muon");
							}else {
								data.put("is_success", false);
								data.put("Erorr", "Số lượng Sách Đã Mượn Chưa Trả Vượt Quá Yêu Cầu");
							}	
						}	
				 }else {
					 data.put("is_success", false);
					 data.put("Erorr", "Không Tìm Thấy Thông Tin Khách Hàng");
				 }
				
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}
	
	public static Date addDays(Date d, int days)
    {
        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
        return d;
    }

	@Override
	public JSONObject returnBook(BorrowTicketsRequest borrowTicketsRequest) {
		JSONObject data = new JSONObject();
		Borrowtickets borrowticket = borrowticketsRepository.getBorrowticketById(borrowTicketsRequest.getId());
		
		borrowticket.setReturn_date(new Date());
		
		borrowticketsRepository.save(borrowticket);
		data.put("is_success", true);
		data.put("messge","Trả sách thành công");
		return data;
	}
	

}
