package com.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Books;
import com.Entity.Customers;

import javax.transaction.Transactional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	@Query(nativeQuery = true, value = " SELECT cm.* FROM customers cm WHERE cm.id=?1")
	Customers getCustomersById(int id);

	
	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = " Update customers Set delete_at=now() WHERE customers.id=?1")
	int deleteCustomer(int id);
	
	@Query (nativeQuery = true, value = " SELECT cu.* FROM customers cu where cu.delete_at is null")
	List<Customers> getListCustomer();




}
