package com.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Books;
import com.Entity.Employees;


@Repository
public interface EmployessRepository extends JpaRepository<Employees, Integer>{
	
	@Query(nativeQuery = true, value = " SELECT em.* FROM employees em where em.id=?1")
	Employees getEmployeesById(int id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " DELETE FROM employees WHERE employees.id=?1 ")
	int deleteEmployeesByid(int id);
	
	
}
