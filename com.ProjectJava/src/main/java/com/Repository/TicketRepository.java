package com.Repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.ticket;

@Repository
public interface TicketRepository extends JpaRepository<ticket, Integer>{
	
	@Transactional
    @Modifying
	@Query(nativeQuery = true, value=" INSERT INTO ticket (create_at,fine_money,borrowtickets_id) " + 
	                                 " VALUES (?1,?2,?3)")
	int createBorrowticket(Date create_at,double fine_money, int borrowtickets_id );
}
