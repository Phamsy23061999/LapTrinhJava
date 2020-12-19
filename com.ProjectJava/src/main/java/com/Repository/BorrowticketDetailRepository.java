package com.Repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.BorrowTicketsDetail;

@Repository
public interface BorrowticketDetailRepository extends JpaRepository<BorrowTicketsDetail, Integer>{
	
	@Transactional
    @Modifying
	@Query(nativeQuery = true, value=" INSERT INTO borrowtickets_detail (books,borrowtickets_id) " + 
	                                 " VALUES (?1,?2)")
	int createBorrowticketDetail(int books, int borrowtickets_id );
	
	@Query(nativeQuery = true, value=" SELECT * From borrowtickets_detail WHere borrowtickets_detail.id=?1 " )
	BorrowTicketsDetail borrowTicketsDetail(int id);
           
	
}
