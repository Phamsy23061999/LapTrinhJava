package com.Repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " DELETE FROM inventory WHERE inventory.id=?1 ")
	int deleteInventoryByid(int id);
	
	@Transactional
    @Modifying
	@Query(nativeQuery = true, value=" INSERT INTO  inventory (quantity,reason,books_id,number_of_lost_books) " + 
	                                 " VALUES (?1,?2,?3,?4)")
	int createInventory(int quantity, String reason, int book_id, int number_of_lost_books );
	
}
