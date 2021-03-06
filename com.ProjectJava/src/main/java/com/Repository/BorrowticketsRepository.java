package com.Repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Borrowtickets;

@Repository
public interface BorrowticketsRepository extends JpaRepository<Borrowtickets, Integer>{
	
	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where bo.id=?1")
	Borrowtickets getBorrowticketById(int id);

	@Query(nativeQuery = true,value = " SELECT bo.customers From borrowtickets bo Where bo.id=?1")
	Customers getCustomersByBorrowTicketId(int id);

	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where bo.delete_at is null group by bo.id")
	List<Borrowtickets> getListBorrowtickets();
	
	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where bo.delete_at is null and"
			+ " year(now())= year(bo.borrow_date) group by bo.id")
	List<Borrowtickets> getListBorrowticketsInYear();
	
	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo ")
	List<Borrowtickets> getBorrowtickets();
	
	

	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where bo.customers_id=?1")
	Borrowtickets getBorrowticketByCustomerId(int customers_id);
	
	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where month(bo.borrow_date)=month(now()) and year(bo.borrow_date)=year(now())")
	List<Borrowtickets> getBorrowTicketsInMonth();

	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where bo.return_date is null  and  month(bo.borrow_date)=month(now()) and year(bo.borrow_date)=year(now())")
	List<Borrowtickets> getBorrowingTicketsInMonth();

	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where  bo.return_date is null and  date(bo.borrow_date)=date(now())"
			+ " and  month(bo.borrow_date)=month(now())"
			+ " and year(bo.borrow_date)=year(now())")
	List<Borrowtickets> getBorrowTicketsInDay();

	@Query(nativeQuery = true,value = " SELECT bo.* From borrowtickets bo Where  bo.return_date is null and date(bo.borrow_date)=date(now())"
			+ " and  month(bo.borrow_date)=month(now())"
			+ " and year(bo.borrow_date)=year(now())")
	List<Borrowtickets> getBorrowingTicketsInDay();


	@Transactional
    @Modifying
	@Query(nativeQuery = true, value=" INSERT INTO borrowtickets (appointment_date,borrow_date,quantity,customers_id,employees_id) " + 
	                                 " VALUES (?1,?2,?3,?4,?5)")
	int createBorrowtickets(Date appointment_date, Date borrow_date, int quantity, int customers_id, int employees_id );
	
	@Transactional
    @Modifying
    @Query(nativeQuery =  true, value = "UPDATE borrowtickets bo "
    		+ " SET bo.appointment_date=?1,bo.borrow_date=?2,bo.quantity=?3,bo.employees_id=?4,bo.status=true "
    		+ " WHERE bo.id=?5 ")
	int updateBorrowticket(Date appointment_date, Date borrow_date, int quantity, int employees_id, int id );
	
	@Transactional
    @Modifying
    @Query(nativeQuery =  true, value = "UPDATE borrowtickets bo "
    		+ " SET bo.return_date ,bo.status=true "
    		+ " WHERE bo.id=?2 ")
	int updateBorrowticketByReturnDate(Date return_date, int id );
	
	 @Query(nativeQuery =  true, value = "Select bo.* From borrowtickets bo Where bo.customers_id=?1 and bo.return_date is null")
	 List<Borrowtickets> checkBorrowingCustomer(int id);
	
}
