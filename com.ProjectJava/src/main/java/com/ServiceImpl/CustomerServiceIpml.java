package com.ServiceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Books;
import com.Entity.BorrowTicketsDetail;
import com.Entity.Borrowtickets;
import com.Entity.Customers;
import com.Entity.Employees;
import com.Entity.ticket;
import com.Repository.BooksRepository;
import com.Repository.BorrowticketDetailRepository;
import com.Repository.BorrowticketsRepository;
import com.Repository.CustomersRepository;
import com.Repository.EmployessRepository;
import com.Repository.TicketRepository;
import com.Request.BorrowTicketsRequest;
import com.Response.BookResponse;
import com.Response.BorrowTicketDetailResponse;
import com.Response.BorrowticketResponse;
import com.Response.CustomerResponse;
import com.service.CustomerService;

import ch.qos.logback.core.pattern.ConverterUtil;
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
			customers.setTagdate(new Date());
			customers.setExpiration_date(addDays(new Date(), 365));
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
			List<Customers> customers = customerRepository.getListCustomer();
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
//				System.out.print("emp != null na");
				 if(customers != null) {
//					 System.out.print("cuss != null na")
					 Date appointment = new Date();
					 Date tagDate = customers.getTagdate();// tạo tag date cho customer là chạy vù vù
					 Date expirationDate = customers.getExpiration_date();
					 Date appointment_date = addDays(appointment, 30);
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
								data.put("message","Tao Thanh Cong Phieu Muon");
							}else {
								data.put("is_success", false);
								data.put("Erorr", "Số lượng Sách Đã Mượn Chưa Trả Vượt Quá Yêu Cầu");
							}
							System.out.println("out na");
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
		try {
			Borrowtickets borrowticket = borrowticketsRepository.getBorrowticketById(borrowTicketsRequest.getId());
			if(borrowticket != null) {
				Date appointment = borrowticket.getAppointment_date();
				Date return_date =new Date();  // now
				long millisAppointmentDate = appointment.getTime();
				long millisReturnDate = return_date.getTime();
				int date = (int)((millisReturnDate- millisAppointmentDate)/(1000*60*60*24));
				if(millisReturnDate > millisAppointmentDate) {
					int totalMoney = date * 5000;
					int ticket = ticketRepository.createBorrowticket(new Date(),totalMoney, borrowticket.getId());
					if(ticket != 0) {
						data.put("is_success", true);
						data.put("message","Bạn Trả Sách Muộn Và Bị Phạt\t"+totalMoney);
						return data;
					}
				}else {
					BorrowTicketsDetail borrowTicketsDetail = borrowticketDetailRepository.getBorrowTicketsDetailByBorrowticketId(borrowticket.getId());
					if(borrowTicketsDetail != null) {
						Books book= bookRepository.getBookById(borrowTicketsDetail.getBook().getId());
						if(book != null) {
							borrowticket.setReturn_date(new Date());
							book.setOld_amount(book.getOld_amount()+1);
							borrowticket = borrowticketsRepository.save(borrowticket);
							bookRepository.save(book);
						}
					}
				}
				data.put("is_success", true);
				data.put("message","Trả sách thành công");		
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}

	@Override
	public JSONObject getBorrowTickets() {
		JSONObject data = new JSONObject();
		try {
			List<Borrowtickets> borrowTickets = borrowticketsRepository.getListBorrowtickets();
			List<BorrowticketResponse> borrowTicketsResponse = new ArrayList<BorrowticketResponse>();
			BorrowTicketDetailResponse borrowTicketsDetails = new BorrowTicketDetailResponse();
			
			
			if(borrowTickets != null) {
				for(Borrowtickets borrow : borrowTickets) {
					BorrowticketResponse borrowticketResponse = new BorrowticketResponse(borrow);
					Employees employees = employessRepository.getEmployeesById(borrow.getEmployess().getId());
					if(employees != null) {
						borrowticketResponse.setEmployess_id(employees.getId());
						borrowticketResponse.setEmployess_name(employees.getFirst_name());
						
						BorrowTicketsDetail borrowTicketsDetail= borrowticketDetailRepository.getBorrowTicketsDetailByBorrowticketId(borrow.getId());
						borrowTicketsDetails.setBorrowTicketsDetail(borrowTicketsDetail);
						
						
							
					}
					Customers customers = customerRepository.getCustomersById(borrow.getCustomers().getId());
					if(customers != null) {
						borrowticketResponse.setCustomers_id(customers.getId());
						borrowticketResponse.setCustomers_name(customers.getFirst_name());
					}
					borrowTicketsResponse.add(borrowticketResponse);
					
					data.put("item", borrowTicketsResponse);
				}
				
			}	
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}

	@Override
	public List<Customers> searchCustomers(Customers cus) {
		ArrayList<Customers> res = new ArrayList<>();
		Customers customer = customerRepository.getCustomersById(cus.getId());
		res.add(customer);
		return res;
	}

	@Override
	public JSONObject deleteCustomer(int id) {
		JSONObject data = new JSONObject();
		try {
			int deleteCustomer = customerRepository.deleteCustomer(id);
			if(deleteCustomer!=0) {
				data.put("is_success", true);
				data.put("message", "Delete thành công");
			}
		} catch (Exception e) {
			data.put("is_success", false);
			data.put("Erorr", "Có lỗi Xảy Ra");
		}
		return data;
	}
	

		
}
