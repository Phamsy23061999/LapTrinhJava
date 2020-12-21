package com.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Entity.Employees;


@Repository
public interface EmployessRepository extends JpaRepository<Employees, Integer>{
	
	@Query(nativeQuery = true, value = " SELECT em.* FROM employees em where em.id=?1")
	Employees getEmployeesById(int id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " DELETE FROM employees WHERE employees.id=?1 ")
	int deleteEmployeesByid(int id);
	
	@Query(nativeQuery = true, value = " Select count(*) " + 
			"from borrowtickets " + 
			"where YEAR(borrow_date)=?1 " + 
			"group by YEAR(borrow_date)")
	int statisticalYear(int year);
	
	@Query(nativeQuery = true, value = "	select count(*) " + 
			"    from borrowtickets " + 
			"	where (month(borrow_date)=1 or month(borrow_date)=2 or month(borrow_date)=3) and year(borrow_date)=?1 " + 
			"	group by year(borrow_date)")
	int quarterlyStatisticsOne(int year);
	
	@Query(nativeQuery = true, value = "	select count(*) " + 
			"    from borrowtickets " + 
			"	where (month(borrow_date)=4 or month(borrow_date)=5 or month(borrow_date)=6)and year(borrow_date)=?1 " + 
			"	group by year(borrow_date)")
	int quarterlyStatisticsTwo(int year);
	
	@Query(nativeQuery = true, value = "	select count(*) " + 
			"    from borrowtickets " + 
			"	where (month(borrow_date)=7 or month(borrow_date)=8 or month(borrow_date)=9) and year(borrow_date)=?1 " + 
			"	group by year(borrow_date)")
	int quarterlyStatisticsThree(int year);
	
	@Query(nativeQuery = true, value = "	select count(*) \r\n" + 
			"    from borrowtickets " + 
			"	where (month(borrow_date)=10 or month(borrow_date)=11 or month(borrow_date)=12) and year(borrow_date)=?1 " + 
			"	group by year(borrow_date)")
	int quarterlyStatisticsFour(int year);
	
}
