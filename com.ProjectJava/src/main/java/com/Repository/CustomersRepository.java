package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer>{
	
	@Query(nativeQuery = true, value = " SELECT cm.* FROM customers cm WHERE cm.id=?1")
	Customers getCustomersById(int id);
	
}
