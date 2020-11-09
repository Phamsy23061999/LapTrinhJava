package com.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Entity.CategoryEntity;
import com.Repository.CategoryRepository;


@Component
public class CategoryDAO {
	 
	@Autowired
	private CategoryRepository categoryReposity;
	
	public CategoryEntity SaveCategory(CategoryEntity entity) {
		return categoryReposity.saveAndFlush(entity);
	}
	
	public Optional<CategoryEntity>  updateCategory(int id) {
		
			return categoryReposity.findById(id);
	}
}
