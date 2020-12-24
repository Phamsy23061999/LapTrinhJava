package com.Repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	@Transactional
    @Modifying
	@Query(nativeQuery = true, value=" INSERT INTO ticket (create_at,fine_money,borrowtickets_id) " + 
	                                 " VALUES (?1,?2,?3)")
	int createBorrowticket( Date create_at,int fine_money, int borrowtickets_id );
	
	@Query(nativeQuery = true, value=" Select * from ticket")
	List<Ticket> getTicket();
}
