package com.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer>{
	
	@Query(nativeQuery = true, value = " SELECT bo.* FROM books bo where bo.id=?1")
	Books getBookById(int id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " Update books Set book_name =?1, description=?2,image=?3,page_number=?4, old_amount=?5 WHERE books.id=?6 ")
	int updateBook(String book_name, String description, String image, int page_number, int old_amount, int id);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = " Update books Set old_amount=?1 WHERE books.id=?2 ")
	int updateBookById(int old_amount, int id);
	

	@Modifying
	@Transactional
	@Query(nativeQuery = true,value = " DELETE FROM books WHERE books.id=?1")
	int deleteBook(int id);
	
	@Query(nativeQuery = true, value= " SELECT bo.* FROM books bo where bo.book_name LIKE %:keysearch%")
	Books getBookByBookName(@Param("keysearch") String keysearch);
}
